package com.flawless.tussle.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.flawless.IListSelectedActivity;
import com.flawless.tussle.R;
import com.flawless.tussle.model.ListItemModel;

import java.util.ArrayList;



public class ListRecyclerAdapter extends RecyclerView.Adapter<ListRecyclerAdapter.ViewHolder> {

    private static final String TAG = "MainRecyclerViewAd";

    //vars
    private ArrayList<ListItemModel> mListSelectedItems = new ArrayList<>();
    private Context mContext;
    private IListSelectedActivity mInterface;



    public ListRecyclerAdapter(Context context, ArrayList<ListItemModel> items) {
        mContext = context;
        mListSelectedItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_select_feed, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        RequestOptions requestOptions = new RequestOptions()
                        .placeholder(R.drawable.ic_launcher_background);


        holder.name.setText(mListSelectedItems.get(position).getTitle());
        holder.subname.setText(mListSelectedItems.get(position).getSubTitle());



        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mListSelectedItems.get(position).getTitle());

                mInterface.inflateQuizBoard(mListSelectedItems.get(position));
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mInterface = (IListSelectedActivity) mContext;
    }

    @Override
    public int getItemCount() {
        return mListSelectedItems.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView name;
        TextView subname;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            subname = itemView.findViewById(R.id.sub_name);
            name = itemView.findViewById(R.id.name);
            cardView = itemView.findViewById(R.id.card_view);

        }
    }
}

















