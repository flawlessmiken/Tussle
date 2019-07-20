package com.flawless.tussle.utils;

import com.flawless.tussle.model.ReviewModel;

import java.util.ArrayList;

public class DummyReview {

    public ArrayList <ReviewModel> DummyReviewAnswersData (){

        ArrayList<ReviewModel>  arrayList = new ArrayList<>();
        ReviewModel model = new ReviewModel("Who killed Goliath?","David","CORRECT");
        arrayList.add(model);

        model = new ReviewModel("Who killed Abel?","Cain","Easu");
        arrayList.add(model);

        model = new ReviewModel("How old was Jesus be fully entering into ministry","30","CORRECT");
        arrayList.add(model);

        model = new ReviewModel("How many chapters has Matthew?","28","CORRECT");
        arrayList.add(model);

        model = new ReviewModel("Which book contain the Longest Chapters","Psalm","CORRECT");
        arrayList.add(model);

        model = new ReviewModel("How old was Sarah before he died","127","120");
        arrayList.add(model);

        return arrayList;
    }
}
