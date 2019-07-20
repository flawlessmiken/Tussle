package com.flawless.tussle.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.flawless.tussle.IMainActivity;
import com.flawless.tussle.R;
import com.flawless.tussle.model.QuizModel;

import java.util.ArrayList;



public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "MainRecyclerViewAd";

    //vars
    private ArrayList<QuizModel> mModel = new ArrayList<>();
    private Context mContext;
    private IMainActivity mInterface;


    public MainRecyclerViewAdapter(Context context, ArrayList<QuizModel> models) {
        mContext = context;
        mModel = models;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_main_feed, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        /*RequestOptions requestOptions = new RequestOptions()
                        .placeholder(R.drawable.ic_launcher_background);*/

        Glide.with(mContext)
                .load(mModel.get(position).getModel_image())

                .into(holder.image);

        holder.name.setText(mModel.get(position).getName());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mModel.get(position).getName());

                mInterface.inflateListSelectedItems(mModel.get(position));
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mInterface = (IMainActivity) mContext;
    }

    @Override
    public int getItemCount() {
        return mModel.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.profile_image);
            name = itemView.findViewById(R.id.name);
            cardView = itemView.findViewById(R.id.card_view);

        }
    }
}

















