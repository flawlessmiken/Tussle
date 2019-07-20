package com.flawless.tussle.adapters;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.flawless.tussle.IMainActivity;
import com.flawless.tussle.R;
import com.flawless.tussle.model.User;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class RankingListRecyclerAdapter extends RecyclerView.Adapter<RankingListRecyclerAdapter.ViewHolder> {

    private static final String TAG = "ConnectionsAdapter";

    //vars
    private ArrayList<User> mUsers = new ArrayList<>();
    private ArrayList<User> mFilteredUsers = new ArrayList<>();
    private Context mContext;
    private IMainActivity mInterface;


    public RankingListRecyclerAdapter(Context context, ArrayList<User> users) {
        mContext = context;
        mUsers = users;
        mFilteredUsers = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_ranking_feed, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        final User user = mFilteredUsers.get(position);

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);

        Glide.with(mContext)
                .load(user.getProfile_image())
                .apply(requestOptions)
                .into(holder.image);


       holder.name.setText(user.getName());
        holder.position.setText(String.valueOf(position + 1));
       holder.points.setText(user.getPoints());
        //holder.coin.setText(user.getPoints());


       /* holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + user.getName());

               mInterface.inflateChallengeRoom(user);
            }
        });*/
    }




    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mInterface = (IMainActivity) mContext;
    }

    @Override
    public int getItemCount() {
        return mFilteredUsers.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

         CircleImageView image;
        TextView name;
        TextView points;
        TextView position;
        RelativeLayout parent;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_user);
            name = itemView.findViewById(R.id.text_playername);
            points = itemView.findViewById(R.id.text_pnts);
            position = itemView.findViewById(R.id.text_position);

        }
    }
}