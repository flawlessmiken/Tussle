package com.flawless.tussle.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.flawless.IListSelectedActivity;
import com.flawless.tussle.R;
import com.flawless.tussle.model.ListItemModel;
import com.flawless.tussle.model.ReviewModel;
import com.like.LikeButton;

import java.util.ArrayList;


public class ReviewAnswerAdapter extends RecyclerView.Adapter<ReviewAnswerAdapter.ViewHolder> {

    private static final String TAG = "MainRecyclerViewAd";

    //vars
    private ArrayList<ReviewModel> mListReviewItems = new ArrayList<>();
    private Context mContext;
    //private IListSelectedActivity mInterface;

    private static final int VIEW_CORRECT= 0;
    private static final int VIEW_WRONG = 1;


    private   int mCount = 0;


    public ReviewAnswerAdapter(Context context, ArrayList<ReviewModel> items) {
        mContext = context;
        mListReviewItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId;

        switch (viewType) {

            case VIEW_CORRECT: {
                layoutId = R.layout.layout_review_correct_feed;
                break;
            }

            case VIEW_WRONG: {
                layoutId = R.layout.layout_review_wrong_feed;

                break;

            }

            default:
                throw new IllegalArgumentException("Invalid view type, value of " + viewType);
        }

        View view = LayoutInflater.from(mContext).inflate(layoutId, parent,false);

        view.setFocusable(true);

        return new ReviewAnswerAdapter.ViewHolder(view);

    }

    private int handleLikeButtonVisibility(){
        mCount++;
        if(mCount <=2){
            mCount= 0;
        }
        return mCount;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        RequestOptions requestOptions = new RequestOptions()
                        .placeholder(R.drawable.ic_launcher_background);


        holder.Question.setText(mListReviewItems.get(position).getQuestion());
        holder.RightAnswer.setText(mListReviewItems.get(position).getRightAnswer());
        holder.WrongAnswer.setText(mListReviewItems.get(position).getWrongAnswer());




        holder.likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mListReviewItems.get(position).getQuestion());


               /* if(handleLikeButtonVisibility()>=1){
                    holder.linearLayout.setVisibility(View.VISIBLE);
                }else holder.linearLayout.setVisibility(View.INVISIBLE);*/

            }
        });
    }




    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        //mInterface = (IListSelectedActivity) mContext;
    }

    @Override
    public int getItemCount() {
        return mListReviewItems.size();
    }

    @Override
    public int getItemViewType(int position) {

        if(mListReviewItems.get(position).getWrongAnswer().equals("CORRECT")){
            return VIEW_CORRECT;
        }else {
            return VIEW_WRONG;
        }
    }




    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView Question;
        TextView RightAnswer;
        TextView WrongAnswer;
        LinearLayout linearLayout;
        LikeButton likeButton;


        public ViewHolder(View itemView) {
            super(itemView);
            Question = itemView.findViewById(R.id.tv_question);
            RightAnswer = itemView.findViewById(R.id.correct_ans);
            WrongAnswer = itemView.findViewById(R.id.wrong_ans);
            likeButton = itemView.findViewById(R.id.heart_button);

        }
    }
}

















