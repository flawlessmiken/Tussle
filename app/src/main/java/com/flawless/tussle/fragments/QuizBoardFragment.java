package com.flawless.tussle.fragments;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.flawless.tussle.IMainActivity;
import com.flawless.tussle.R;
import com.flawless.tussle.database.AppDatabase;
import com.flawless.tussle.database.AppExecutors;
import com.flawless.tussle.database.QuestionsEntry;
import com.flawless.tussle.model.ReviewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class QuizBoardFragment extends Fragment  implements View.OnClickListener {


    //private OnFragmentInteractionListener mListener;
    AppDatabase mDb;
    List<QuestionsEntry> mSelectedQuestionList = new ArrayList<>();
    QuestionsEntry currentQuestionEntry;
    int currentPosition;
    int HASFINISHED;

    private IMainActivity mInterface;


    private ProgressBar progressBarCircle;
    //private EditText editTextMinute;
    private TextView textViewTime;
    private CountDownTimer countDownTimer;
    private TextView optionA;
    private TextView optionB;
    private TextView optionC;
    private TextView optionD;
    private TextView questionView;
    private TextView questionCountView;

    private long timeCountInMilliSeconds = 1 * 10000;
    Boolean isCorrect;

    public QuizBoardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz_board_cons, container, false);
        mInterface = (IMainActivity) getActivity();
        currentPosition = 0;
        initViews(view);
        initializeDataBase();
        startStop();
        return view;
    }



    ////////////:::::::::::::::::::::: Database Loader:::::::::::::::::::////////////////////////////////////

    private void initializeDataBase() {
        mDb = AppDatabase.getInstance(getActivity());

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final int count = mDb.mQuestionDao().getAllQuestionsCount();
                final List<QuestionsEntry> questions = mDb.mQuestionDao().loadAllQuestions();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mSelectedQuestionList = questions;
                        currentQuestionEntry = mSelectedQuestionList.get(currentPosition);
                        feedUiWithData(currentQuestionEntry);
                    }
                });
            }
        });

    }



    private void feedUiWithData(QuestionsEntry question){
        if(question != null){
            questionView.setText(question.getQuestion());
            optionA.setText(question.getOptionA());
            optionB.setText(question.getOptionB());
            optionC.setText(question.getOptionC());
            optionD.setText(question.getOptionD());
            questionCountView.setText(String.valueOf(currentPosition +1)+"/"+String.valueOf(mSelectedQuestionList.size()));
        }
    }


    private void initViews(View view) {

        progressBarCircle = (ProgressBar) view.findViewById(R.id.progressBarCircle);
        textViewTime = (TextView) view.findViewById(R.id.textViewTime);
        optionA   = (TextView) view.findViewById(R.id.text_opt_a);
        optionB   = (TextView) view.findViewById(R.id.text_optn_b);
        optionC   = (TextView) view.findViewById(R.id.text_optn_c);
        optionD   = (TextView) view.findViewById(R.id.text_optn_d);
        questionView   = (TextView) view.findViewById(R.id.text_question);
        questionCountView  = (TextView) view.findViewById(R.id.tv_count);

        optionA.setOnClickListener(this);
        optionB.setOnClickListener(this);
        optionC.setOnClickListener(this);
        optionD.setOnClickListener(this);

    }



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text_opt_a:
                delayPopulation();

                isCorrect = checkCorrectnessOfAnswer(currentQuestionEntry.getOptionA());
                if(isCorrect){
                    startBlinkingAnimation(optionA);
                }else{
                    blinkRightAnswer(optionA);
                }

                break;

            case R.id.text_optn_b:
                delayPopulation();
                 isCorrect = checkCorrectnessOfAnswer(currentQuestionEntry.getOptionB());
                if(isCorrect){
                    startBlinkingAnimation(optionB);
                }else{
                    blinkRightAnswer(optionB);
                }
                break;
            case R.id.text_optn_c:
                delayPopulation();
                isCorrect = checkCorrectnessOfAnswer(currentQuestionEntry.getOptionC());
                if(isCorrect){
                    startBlinkingAnimation(optionC);
                }else{
                    blinkRightAnswer(optionC);
                }
                break;
            case R.id.text_optn_d:
                delayPopulation();
                isCorrect = checkCorrectnessOfAnswer(currentQuestionEntry.getOptionD());
                if(isCorrect){
                    startBlinkingAnimation(optionD);
                }else{
                    blinkRightAnswer(optionD);
                }
                break;

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void blinkRightAnswer(View view){

        if(view != null){
        view.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.wrongans));
        }
        if(currentQuestionEntry.getAnswer().equals(currentQuestionEntry.getOptionA())){
            startBlinkingAnimation(optionA);
        }else if (currentQuestionEntry.getAnswer().equals(currentQuestionEntry.getOptionB())){
            startBlinkingAnimation(optionB);
        }else if (currentQuestionEntry.getAnswer().equals(currentQuestionEntry.getOptionC())){
            startBlinkingAnimation(optionC);
        }else if (currentQuestionEntry.getAnswer().equals(currentQuestionEntry.getOptionD())){
            startBlinkingAnimation(optionD);
        }
    }


   private void delayPopulation(){

       new Timer().schedule(
               new TimerTask() {
                   @Override
                   public void run() {


                       getActivity().runOnUiThread(new Runnable() {
                           @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                           @Override
                           public void run() {
                               if(HASFINISHED == 10000000){
                                   Toast.makeText(getActivity(), "End", Toast.LENGTH_SHORT).show();
                                   ReviewModel model = new ReviewModel("gggg bbbbb bbbbbb bbbbb","bbbbbbb","bbbb");
                                   mInterface.inflateReviwBoard(model);
                               }else{
                               currentQuestionEntry = mSelectedQuestionList.get(nextQuestionPosition());
                               resetView();
                               feedUiWithData(currentQuestionEntry);
                               reset();
                               }
                           }
                       });
                   }
               },
               1400
       );

   }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void startBlinkingAnimation(View view) {
        stopCountDownTimer();

        Animation startAnimation = AnimationUtils.loadAnimation(getActivity(),R.anim.blink);
        view.startAnimation(startAnimation);
        view.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.correctans));
        optionA.setEnabled(false);
        optionB.setEnabled(false);
        optionC.setEnabled(false);
        optionD.setEnabled(false);
    }


    private Boolean checkCorrectnessOfAnswer(String optionClicked){
        if(optionClicked.equals(currentQuestionEntry.getAnswer())){
          /*  if(optionClicked.equals(currentQuestionEntry.getOptionA())){
                optionA.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.correctans));
                startBlinkingAnimation(optionA);
            }else if(optionClicked.equals(currentQuestionEntry.getOptionB())){
                optionB.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.correctans));
                startBlinkingAnimation(optionB);
            }else if(optionClicked.equals(currentQuestionEntry.getOptionC())){
                optionC.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.correctans));
                startBlinkingAnimation(optionC);
            }else if(optionClicked.equals(currentQuestionEntry.getOptionD())){
                optionD.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.correctans));
                startBlinkingAnimation(optionD);
            }*/
            return true;
        }else{

            return false;
        }
    }

    private int nextQuestionPosition(){
        if (currentPosition < (mSelectedQuestionList.size()-2 )){
        currentPosition++;
        }else{
           HASFINISHED = 10000000;
        }
        return currentPosition;

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void resetView(){
        optionA.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.btn_options_wrap));
        optionB.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.btn_options_wrap));
        optionC.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.btn_options_wrap));
        optionD.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.btn_options_wrap));
        optionA.setEnabled(true);
        optionB.setEnabled(true);
        optionC.setEnabled(true);
        optionD.setEnabled(true);
    }
























    ////////////:::::::::::::::::::::: for CountDown for CountDown for CountDown for CountDown

    private enum TimerStatus {
        STARTED,
        STOPPED
    }

    private QuizBoardFragment.TimerStatus timerStatus = QuizBoardFragment.TimerStatus.STOPPED;


    private void startStop() {

        setProgressBarValues();
        timerStatus = QuizBoardFragment.TimerStatus.STARTED;
        // call to start the count down timer
        startCountDownTimer();

        /*if (timerStatus == TimerStatus.STOPPED) {

            // call to initialize the timer values
            setTimerValues();
            // call to initialize the progress bar values
            setProgressBarValues();
            // showing the reset icon
            imageViewReset.setVisibility(View.VISIBLE);
            // changing play icon to stop icon
            imageViewStartStop.setImageResource(R.drawable.icon_stop);
            // making edit text not editable
            editTextMinute.setEnabled(false);
            // changing the timer status to started
            timerStatus = TimerStatus.STARTED;
            // call to start the count down timer
            startCountDownTimer();

        } else {

            // hiding the reset icon
            imageViewReset.setVisibility(View.GONE);
            // changing stop icon to start icon
            imageViewStartStop.setImageResource(R.drawable.icon_start);
            // making edit text editable
            editTextMinute.setEnabled(true);
            // changing the timer status to stopped
            timerStatus = TimerStatus.STOPPED;
            stopCountDownTimer();

        }*/

    }


    private void startCountDownTimer() {

        countDownTimer = new CountDownTimer(timeCountInMilliSeconds, 50) {
            @Override
            public void onTick(long millisUntilFinished) {

                textViewTime.setText(hmsTimeFormatter(millisUntilFinished));

                progressBarCircle.setProgress((int) (millisUntilFinished / 1000));

            }
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onFinish() {

                textViewTime.setText(hmsTimeFormatter(timeCountInMilliSeconds));
                // call to initialize the progress bar values
                setProgressBarValues();
                // making edit text editable
                //editTextMinute.setEnabled(true);
                // changing the timer status to stopped
                timerStatus = TimerStatus.STOPPED;
                Toast.makeText(getContext(), "Time Up", Toast.LENGTH_SHORT).show();
                blinkRightAnswer(null);
                delayPopulation();
            }

        }.start();
        countDownTimer.start();
    }

    /**
     * method to stop count down timer
     */
    private void stopCountDownTimer() {
        countDownTimer.cancel();
    }

    private void reset() {
        stopCountDownTimer();
        startCountDownTimer();
    }

    /**
     * method to set circular progress bar values
     */
    private void setProgressBarValues() {

        progressBarCircle.setMax((int) timeCountInMilliSeconds / 1000);
        progressBarCircle.setProgress((int) timeCountInMilliSeconds / 1000);
    }

    private String hmsTimeFormatter(long milliSeconds) {

        String hms = String.format("%02d",
                TimeUnit.MILLISECONDS.toSeconds(milliSeconds));

        return hms;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*TimeUnit.MILLISECONDS.toMinutes(milliSeconds),
            TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)));
*/






    /*public void tryal(){

    case R.id.text_opt_a:
    startBlinkingAnimation(view);
    Boolean isCorrect = checkCorrectnessOfAnswer(currentQuestionEntry.getOptionA());

                if(isCorrect){
        optionA.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.circle_green));
    }

                new Timer().schedule(
                        new TimerTask() {
        @Override
        public void run() {
            currentQuestionEntry = mSelectedQuestionList.get(nextQuestionPostion());
        }
    },
            2000
            );
    feedUiWithData(currentQuestionEntry);

                break;

    }*/
}
