package com.flawless.tussle.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flawless.tussle.R;
import com.flawless.tussle.model.ListItemModel;
import com.flawless.tussle.utils.ItemSelectedLists;
import com.flawless.tussle.adapters.ListRecyclerAdapter;

import java.util.ArrayList;


public class SelectedQuizListFragment extends Fragment {

    private static final String TAG = "SelectedQuizListFragmen";




    //widgets
    private RecyclerView mRecyclerView;

    //vars
    private ArrayList<ListItemModel> mMatches = new ArrayList<>();
    private LinearLayoutManager mLinearLayoutManager;
    private ListRecyclerAdapter mRecyclerViewAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.fragment_selected_quiz_list,container,false);

        mRecyclerView = view.findViewById(R.id.recycler_view);
        findMatches();
        return view;
    }

    private void findMatches() {
        ItemSelectedLists items = new ItemSelectedLists();
        if (mMatches != null) {
            mMatches.clear();
        }
        for (ListItemModel model : items.ListItems) {
            mMatches.add(model);
        }
        if (mRecyclerViewAdapter == null) {
            initRecyclerView();
        }
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerViewAdapter = new ListRecyclerAdapter(getActivity(), mMatches);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

}
