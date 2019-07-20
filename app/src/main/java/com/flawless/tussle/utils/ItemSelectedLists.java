package com.flawless.tussle.utils;


import com.flawless.tussle.model.ListItemModel;

public class ItemSelectedLists {

    public ListItemModel[] ListItems = {Basic, Amature, Intermediate, Professional};




    public static final ListItemModel Basic = new ListItemModel("Basic",
            "Rounds 20 | points 20");

    public static final ListItemModel Amature = new ListItemModel("Amature",
            "Rounds 15 | points 25");

    public static final ListItemModel Intermediate = new ListItemModel("Intermediate",
            "Rounds 20 | points 40");


    public static final ListItemModel Professional = new ListItemModel("Professional",
            "Rounds 40 | points 100");
}
