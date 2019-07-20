package com.flawless.tussle.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flawless.tussle.R;
import com.flawless.tussle.adapters.ListRecyclerAdapter;
import com.flawless.tussle.adapters.ReviewAnswerAdapter;
import com.flawless.tussle.model.ListItemModel;
import com.flawless.tussle.model.ReviewModel;
import com.flawless.tussle.utils.DummyReview;
import com.flawless.tussle.utils.ItemSelectedLists;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewAnswerFragment extends Fragment {

    private RecyclerView mRecyclerView;

    //vars
    private ArrayList<ReviewModel> mMatches = new ArrayList<>();
    private LinearLayoutManager mLinearLayoutManager;
    private ReviewAnswerAdapter mReViewAnsAdapter;


    public ReviewAnswerFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_review_answer, container, false);

        mRecyclerView = view.findViewById(R.id.recycler_view);
        // Inflate the layout for this fragment
        findMatches();

        return view;

    }

    private void findMatches() {
        DummyReview items = new DummyReview();
        if (mMatches != null) {
            mMatches.clear();
        }

            mMatches= items.DummyReviewAnswersData();

        if (mReViewAnsAdapter == null) {
            initRecyclerView();
        }
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mReViewAnsAdapter = new ReviewAnswerAdapter(getActivity(), mMatches);
        mRecyclerView.setAdapter(mReViewAnsAdapter);
    }


}
