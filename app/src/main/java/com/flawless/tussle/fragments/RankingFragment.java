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
import com.flawless.tussle.adapters.RankingListRecyclerAdapter;
import com.flawless.tussle.adapters.ListRecyclerAdapter;
import com.flawless.tussle.model.ListItemModel;
import com.flawless.tussle.model.User;
import com.flawless.tussle.utils.DummyUsers;
import com.flawless.tussle.utils.ItemSelectedLists;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RankingFragment extends Fragment {


    private static final String TAG = "RankingFragment";




    //widgets
    private RecyclerView mRecyclerView;

    //vars
    private ArrayList<User> mMatches = new ArrayList<>();
    private LinearLayoutManager mLinearLayoutManager;
    private RankingListRecyclerAdapter mRecyclerViewAdapter;


    public RankingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = getLayoutInflater().inflate(R.layout.fragment_selected_quiz_list,container,false);

        mRecyclerView = view.findViewById(R.id.recycler_view);
        findMatches();
        return view;
    }

    private void findMatches() {
        DummyUsers users = new DummyUsers();
        if (mMatches != null) {
            mMatches.clear();
        }
        for (User user : users.USERS) {
            mMatches.add(user);
        }
        if (mRecyclerViewAdapter == null) {
            initRecyclerView();
        }

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerViewAdapter = new RankingListRecyclerAdapter(getActivity(), mMatches);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

}
