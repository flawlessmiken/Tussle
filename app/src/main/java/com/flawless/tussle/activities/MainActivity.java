package com.flawless.tussle.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.flawless.IListSelectedActivity;
import com.flawless.tussle.fragments.HomeFragment;
import com.flawless.tussle.IMainActivity;
import com.flawless.tussle.R;
import com.flawless.tussle.fragments.QuizBoardFragment;
import com.flawless.tussle.fragments.RankingFragment;
import com.flawless.tussle.fragments.ReviewAnswerFragment;
import com.flawless.tussle.fragments.SelectedQuizListFragment;
import com.flawless.tussle.fragments.UserProfileFragment;
import com.flawless.tussle.model.FragmentTag;
import com.flawless.tussle.model.ListItemModel;
import com.flawless.tussle.model.QuizModel;
import com.flawless.tussle.model.ReviewModel;
import com.flawless.tussle.model.User;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IMainActivity , IListSelectedActivity, BottomNavigationViewEx.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    private BottomNavigationViewEx bottomNavigationViewEx;


    //vars
    private HomeFragment mHomeFragment;
    private QuizBoardFragment mQuizBoardFragment;
    private ReviewAnswerFragment mReviewAnswerFragment;
    private SelectedQuizListFragment mSelectedQuizListFragment;
    private UserProfileFragment mUserProfileFragment;
    private RankingFragment mRankingFragment;

    //var
    private ArrayList<String> mFragmentsTags = new ArrayList<>();
    private ArrayList<FragmentTag> mFragment = new ArrayList<>();


    //constants
    private static final int HOME_FRAGMENT = 0;
    private static final int MIDDlE_FRAGMENT = 1;
    private static final int USER_FRAGMENT = 2;
    private int mExitCount = 0;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.bottom_nav_home:
                mFragmentsTags.clear();
                mFragmentsTags = new ArrayList<>();
                menuItem.setChecked(true);
                init();

                break;

            case R.id.bottom_results:

                Log.d(TAG, "onNavigationItemSelected: Settings.");
                if (mRankingFragment == null) {
                    mRankingFragment = new RankingFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.add(R.id.main_content_frame, mRankingFragment, getString(R.string.tag_fragment_rank_list));
                    transaction.commit();
                    mFragmentsTags.add(getString(R.string.tag_fragment_rank_list));
                    mFragment.add(new FragmentTag(mRankingFragment, getString(R.string.tag_fragment_rank_list)));
                } else {
                    mFragmentsTags.remove(getString(R.string.tag_fragment_rank_list));
                    mFragmentsTags.add(getString(R.string.tag_fragment_rank_list));
                }
                menuItem.setChecked(true);
                setFragmentVisibilities(getString(R.string.tag_fragment_rank_list));
                break;

            case R.id.bottom_user_profile:
                Log.d(TAG, "onNavigationItemSelected: HomeFragment");


                /* mUserProfileFragment = new UserProfileFragment();
                 transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_content_frame, mUserProfileFragment, getString(R.string.tag_fragment_user_profile));

                transaction.commit();*/


                Log.d(TAG, "onNavigationItemSelected: Settings.");
                if (mUserProfileFragment == null) {
                    mUserProfileFragment = new UserProfileFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.add(R.id.main_content_frame, mUserProfileFragment, getString(R.string.tag_fragment_user_profile));
                    transaction.commit();
                    mFragmentsTags.add(getString(R.string.tag_fragment_user_profile));
                    mFragment.add(new FragmentTag(mUserProfileFragment, getString(R.string.tag_fragment_user_profile)));
                } else {
                    mFragmentsTags.remove(getString(R.string.tag_fragment_user_profile));
                    mFragmentsTags.add(getString(R.string.tag_fragment_user_profile));
                }
                setFragmentVisibilities(getString(R.string.tag_fragment_user_profile));
                menuItem.setChecked(true);
                break;

        }
        return false;
    }

    private void setNavigationIcon(String tagname) {
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = null;
        if (tagname.equals(getString(R.string.tag_fragment_home))) {
            Log.d(TAG, "setNavigationIcon: home fragment is visible");
            menuItem = menu.getItem(HOME_FRAGMENT);
            menuItem.setChecked(true);
        }
        else if (tagname.equals(getString(R.string.tag_fragment_select_list))) {
            Log.d(TAG, "setNavigationIcon: Middle fragment is visible");
            menuItem = menu.getItem(MIDDlE_FRAGMENT);
            menuItem.setChecked(true);
        }
        else if (tagname.equals(getString(R.string.tag_fragment_user_profile))) {
            Log.d(TAG, "setNavigationIcon: user profile fragment is visible");
            menuItem = menu.getItem(USER_FRAGMENT);
            menuItem.setChecked(true);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationViewEx = findViewById(R.id.bottom_nav_view);

        bottomNavigationViewEx.setOnNavigationItemSelectedListener(this);

        init();
        initBottomNavigationView();

    }


    private void init() {

        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.main_content_frame, mHomeFragment, getString(R.string.tag_fragment_home));
            transaction.commit();
            mFragmentsTags.add(getString(R.string.tag_fragment_home));
            mFragment.add(new FragmentTag(mHomeFragment, getString(R.string.tag_fragment_home)));
        } else {
            mFragmentsTags.remove(getString(R.string.tag_fragment_home));
            mFragmentsTags.add(getString(R.string.tag_fragment_home));
        }

        setFragmentVisibilities(getString(R.string.tag_fragment_home));
    }


    private void initBottomNavigationView() {
        Log.d(TAG, "initBottomNavigationView: initialising the bottom view");
        //bottomNavigationViewEx.enableAnimation(false);

    }


    @Override
    public void inflateListSelectedItems(QuizModel model) {

        /*Bundle args = new Bundle();
        args.putParcelable(getString(R.string.intent_user), user);
        fragment.setArguments(args);*/
        if (mSelectedQuizListFragment != null) {
            getSupportFragmentManager().beginTransaction().remove(mSelectedQuizListFragment).commitAllowingStateLoss();
        }
        mSelectedQuizListFragment = new SelectedQuizListFragment();
        //Bundle args = new Bundle();
        //args.putParcelable(getString(R.string.intent_message), message);
        //mChatFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_content_frame, mSelectedQuizListFragment, getString(R.string.tag_fragment_select_list));
        transaction.commit();
        mFragmentsTags.add(getString(R.string.tag_fragment_select_list));
        mFragment.add(new FragmentTag(mSelectedQuizListFragment, getString(R.string.tag_fragment_select_list)));
        setFragmentVisibilities(getString(R.string.tag_fragment_select_list));

    }

    @Override
    public void inflateReviwBoard(ReviewModel reviewModel) {

        if (mReviewAnswerFragment != null) {
            getSupportFragmentManager().beginTransaction().remove(mReviewAnswerFragment).commitAllowingStateLoss();
        }
        mReviewAnswerFragment = new ReviewAnswerFragment();
        //Bundle args = new Bundle();
        //args.putParcelable(getString(R.string.intent_message), message);
        //mChatFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_content_frame, mReviewAnswerFragment, getString(R.string.tag_fragment_review_ans));
        transaction.commit();
        mFragmentsTags.add(getString(R.string.tag_fragment_review_ans));
        mFragment.add(new FragmentTag(mReviewAnswerFragment, getString(R.string.tag_fragment_review_ans)));
        setFragmentVisibilities(getString(R.string.tag_fragment_review_ans));
    }

    @Override
    public void inflateChallengeRoom(User user) {

    }

    @Override
    public void inflateQuizBoard(ListItemModel item) {


        if (mQuizBoardFragment != null) {
            getSupportFragmentManager().beginTransaction().remove(mQuizBoardFragment).commitAllowingStateLoss();
        }
        mQuizBoardFragment = new QuizBoardFragment();
        //Bundle args = new Bundle();
        //args.putParcelable(getString(R.string.intent_message), message);
        //mChatFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_content_frame, mQuizBoardFragment, getString(R.string.tag_fragment_quiz_board));
        transaction.commit();
        mFragmentsTags.add(getString(R.string.tag_fragment_quiz_board));
        mFragment.add(new FragmentTag(mQuizBoardFragment, getString(R.string.tag_fragment_quiz_board)));
        setFragmentVisibilities(getString(R.string.tag_fragment_quiz_board));




        /*Bundle args = new Bundle();
        args.putParcelable(getString(R.string.intent_user), user);
        fragment.setArguments(args);*/


    }




    private void hideBottomNavigation() {
        if (bottomNavigationViewEx != null) {
            bottomNavigationViewEx.setVisibility(View.GONE);
        }
    }

    private void showBottomNavigation() {
        if (bottomNavigationViewEx != null) {
            bottomNavigationViewEx.setVisibility(View.VISIBLE);
        }
    }


    private void setFragmentVisibilities(String tagname) {
        if (tagname.equals(getString(R.string.tag_fragment_home)))
            showBottomNavigation();
        else if (tagname.equals(getString(R.string.tag_fragment_select_list)))
            hideBottomNavigation();
        else if (tagname.equals(getString(R.string.tag_fragment_user_profile)))
            showBottomNavigation();
        else if (tagname.equals(getString(R.string.tag_fragment_rank_list)))
            showBottomNavigation();
        else if (tagname.equals(getString(R.string.tag_fragment_quiz_board)))
            hideBottomNavigation();
        else if (tagname.equals(getString(R.string.tag_fragment_review_ans)))
            hideBottomNavigation();

        for (int i = 0; i < mFragment.size(); i++) {
            if (tagname.equals(mFragment.get(i).getTag())) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.show((mFragment.get(i).getFragment()));
                transaction.commit();
            } else {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.hide((mFragment.get(i).getFragment()));
                transaction.commit();
            }
        }
       setNavigationIcon(tagname);

        //printBackStack();
    }

    @Override
    public void onBackPressed() {
        int backStackCount = mFragmentsTags.size();
        if (backStackCount > 1) {


            String topFragmentTag = mFragmentsTags.get(backStackCount - 1);

            String newTopFragmentTag = mFragmentsTags.get(backStackCount - 2);

            if(topFragmentTag.equals(getString(R.string.tag_fragment_review_ans))){
                setFragmentVisibilities(mFragmentsTags.get(backStackCount - 3));
            }else {
                setFragmentVisibilities(newTopFragmentTag);
            }
            mFragmentsTags.remove(topFragmentTag);

            mExitCount = 0;
        } else if (backStackCount == 1) {
            String topFragmentTag = mFragmentsTags.get(backStackCount - 1);
            if (topFragmentTag.equals(getString(R.string.tag_fragment_home))) {
                // mHomeFragment.scrollToTop();
                mExitCount++;
                Toast.makeText(this, "1 more click to exit", Toast.LENGTH_SHORT).show();
            }
            if (mExitCount >= 2 ){
                mExitCount++;
                super.onBackPressed();

            }
        }
    }



}
