package com.flawless.tussle.model;

import android.os.Parcel;
import android.os.Parcelable;


public class User implements Parcelable{

    private String profile_image;
    private String name;
    private String gender;
    private String rank;
    private String coins;
    private String points;


    public User(String profile_image, String name, String gender, String rank, String coins, String points) {
        this.profile_image = profile_image;
        this.name = name;
        this.gender = gender;
        this.rank = rank;
        this.coins = coins;
        this.points = points;
    }

    public User() {

    }


    protected User(Parcel in) {
        profile_image = in.readString();
        name = in.readString();
        gender = in.readString();
        rank = in.readString();
        coins = in.readString();
        points = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getCoins() {
        return coins;
    }

    public void setCoins(String coins) {
        this.coins = coins;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(profile_image);
        parcel.writeString(name);
        parcel.writeString(gender);
        parcel.writeString(rank);
        parcel.writeString(coins);
        parcel.writeString(points);
    }
}
