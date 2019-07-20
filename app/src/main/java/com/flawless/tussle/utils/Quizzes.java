package com.flawless.tussle.utils;

import android.net.Uri;

import com.flawless.tussle.R;
import com.flawless.tussle.model.QuizModel;

public class Quizzes {


    public QuizModel[] Quizzes = {Easy, Medium, Hard, General, Old, New};



    public static final QuizModel Hard = new QuizModel(Uri.parse
            ("android.resource://com.flawless.tussle/" + R.drawable.elijah).toString(),
            "Hard Level Quiz");

    public static final QuizModel Medium = new QuizModel(Uri.parse
            ("android.resource://com.flawless.tussle/" + R.drawable.jonah).toString(),
            "Medium Level Quiz");

    public static final QuizModel Easy = new QuizModel(Uri.parse
            ("android.resource://com.flawless.tussle/" + R.drawable.jesus).toString(),
            "Easy Level Quiz");

    public static final QuizModel Old = new QuizModel(Uri.parse
            ("android.resource://com.flawless.tussle/" + R.drawable.fire).toString(),
            "Old Testament Quiz");

    public static final QuizModel New = new QuizModel(Uri.parse
            ("android.resource://com.flawless.tussle/" + R.drawable.stuck).toString(),
            "New Testament Quiz");
    public static final QuizModel General = new QuizModel(Uri.parse
            ("android.resource://com.flawless.tussle/" + R.drawable.noah).toString(),
            "General Bible Quiz");
}
