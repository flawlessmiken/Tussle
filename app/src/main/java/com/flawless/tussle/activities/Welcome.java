package com.flawless.tussle.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.flawless.tussle.R;
import com.flawless.tussle.database.AppDatabase;
import com.flawless.tussle.database.AppExecutors;
import com.flawless.tussle.database.QuestionsEntry;
import com.flawless.tussle.utils.LocalQuestions;

import java.util.ArrayList;

public class Welcome extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Welcome";

    Button btnOpenMain;
    AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Log.d(TAG, "onCreate: ");
        initializeDataBase();


        btnOpenMain = (Button) findViewById(R.id.button);
        btnOpenMain.setOnClickListener(this);
    }





    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            Intent intent = new Intent(Welcome.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }
    }

    private void initializeDataBase(){
        mDb = AppDatabase.getInstance(getApplicationContext());

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final int count = mDb.mQuestionDao().getAllQuestionsCount();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (!(count > 1)) {
                            addQuestionToDatabase();

                        }
                    }
                });

            }
        });
    }




    private void addQuestionToDatabase() {

        LocalQuestions localQuestions = new LocalQuestions();

        ArrayList<QuestionsEntry>  questionsEntries = localQuestions.QuestionsEntryArrayList();

        for (int i = 0; i < questionsEntries.size(); i++) {
            final QuestionsEntry questionsEntry = questionsEntries.get(i);

            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    mDb.mQuestionDao().addQuestion(questionsEntry);
                }
            });
        }
    }


}
