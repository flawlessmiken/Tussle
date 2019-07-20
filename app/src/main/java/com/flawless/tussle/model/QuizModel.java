package com.flawless.tussle.model;

import android.os.Parcel;
import android.os.Parcelable;

public class QuizModel implements Parcelable {


    private String model_image;
    private String name;

    public QuizModel(){}

    protected QuizModel(Parcel in) {
        model_image = in.readString();
        name = in.readString();
    }

    public QuizModel(String model_image, String name) {
        this.model_image = model_image;
        this.name = name;
    }

    public static final Creator<QuizModel> CREATOR = new Creator<QuizModel>() {
        @Override
        public QuizModel createFromParcel(Parcel in) {
            return new QuizModel(in);
        }

        @Override
        public QuizModel[] newArray(int size) {
            return new QuizModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }



    public String getModel_image() {
        return model_image;
    }

    public void setModel_image(String model_image) {
        this.model_image = model_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(model_image);
        parcel.writeString(name);
    }
}
