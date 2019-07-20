package com.flawless.tussle.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flawless.tussle.R;
import com.flawless.tussle.adapters.MainRecyclerViewAdapter;
import com.flawless.tussle.model.QuizModel;
import com.flawless.tussle.utils.Quizzes;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    //constants
    private static final int NUM_COLUMNS = 2;

    //widgets
    private RecyclerView mRecyclerView;

    //vars
    private ArrayList<QuizModel> mMatches = new ArrayList<>();
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private MainRecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Log.d(TAG, "onCreateView: started.");
        mRecyclerView = view.findViewById(R.id.recycler_view);

        findMatches();

        return view;
    }

    private void findMatches() {
        Quizzes quizes = new Quizzes();
        if (mMatches != null) {
            mMatches.clear();
        }
        for (QuizModel model : quizes.Quizzes) {
            mMatches.add(model);
        }
        if (mRecyclerViewAdapter == null) {
            initRecyclerView();
        }
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mRecyclerViewAdapter = new MainRecyclerViewAdapter(getActivity(), mMatches);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }


}
