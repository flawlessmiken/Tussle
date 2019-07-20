package com.flawless.tussle.utils;

import com.flawless.tussle.database.QuestionsEntry;

import java.util.ArrayList;

public class LocalQuestions {



    public String OLD_TESTAMENT = "old testament";
    public String NEW_TESTAMENT = "new testament";

    public String EASY = "easy";
    public String MEDIUM = "medium";
    public String HARD = "hard";


    private String Question = "";
    private String OptionA;
    private String OptionB;
    private String OptionC;
    private String OptionD;
    private String Answer;
    private String BibleSource;
    private String Category;
    private String Level;
    private boolean isLiked;


    public ArrayList<QuestionsEntry> QuestionsEntryArrayList (){

        ArrayList<QuestionsEntry> entries = new ArrayList<>();


        ///////////////////////////////////////////////////////////////////////////////////////
        Question = "The Lord of host rained ​manna​ for His people on the wilderness for?";
        OptionA = "70 years";
        OptionB =  "50 years";
        OptionC = "40 years" ;
        OptionD = "30 years";
        Answer = "40 years";
        BibleSource = "Exodus 16: 35";          ///////////////////// 1 ////////////////////////////////
        Category = OLD_TESTAMENT;
        Level = EASY;
        isLiked = false;

        QuestionsEntry mQuestion = new  QuestionsEntry ( Question,OptionA,OptionB,OptionC,OptionD,Answer,
                BibleSource,Category,Level,isLiked);
        entries.add(mQuestion);
        ////////////////////////////////////////////////////////////////////////////////////////////////////


        mQuestion = new  QuestionsEntry ( "For where your ​treasure​ is, there will your __________ also be?",
                "Mind","Heart","Body", "Spirit",
                "Heart","",NEW_TESTAMENT,EASY,false);
        entries.add(mQuestion);


        mQuestion = new  QuestionsEntry ( "Who said, where you are going, I will go; where you will lodge, I would lodge; your people shall be my people, and your God, would be my God?",
                "Mary","Ruth","Abigail",
                "Sarah","Ruth","",OLD_TESTAMENT,EASY,false);
        entries.add(mQuestion);


        mQuestion = new  QuestionsEntry ( "Which Prophet caused an axe to float on the surface of water?",
                "Elisha","Samuel","Elijah", "Isaiah",
                "Elisha","",OLD_TESTAMENT,EASY,false);
        entries.add(mQuestion);


        mQuestion = new  QuestionsEntry ( "Our Redeemer entreats us to forgive our neighbour...",
                "77 × 7","70 × 7","17  × 7", "7 × 7",
                "70 × 7","",NEW_TESTAMENT,EASY,false);
        entries.add(mQuestion);



        mQuestion = new  QuestionsEntry ( "Who slew the giant who had six fingers on each hand, and six toes on each foot..?",
                "Samson","Absalom","Gideon", "Jonathan",
                "Jonathan","2 sam 21: 21",OLD_TESTAMENT,HARD,false);
        entries.add(mQuestion);


        mQuestion = new  QuestionsEntry ( "Blessed are the pure in heart, for they shall.",
                "see God","obtain mercy","be called children of God", " overcome the world",
                "see God","matthew 5: 8",NEW_TESTAMENT,EASY,false);
        entries.add(mQuestion);

        mQuestion = new  QuestionsEntry ( "God did not permit King David to build His temple because...?",
                " David would soon die","David was not good at that","David was not ready", "David shed too much blood",
                "David shed too much blood","",OLD_TESTAMENT,EASY,false);
        entries.add(mQuestion);



        mQuestion = new  QuestionsEntry ( "The wise men who gave gifts to baby Jesus, came from the...",
                "west","east","north", "south",
                "east","",NEW_TESTAMENT,EASY,false);
        entries.add(mQuestion);



        entries.add(mQuestion);mQuestion = new  QuestionsEntry ( "Jesus said; \" ALL THOSE who are heavy burdened should come to me, and I will give them _________\"",
                "a promise","abode","food", "rest",
                "rest","",NEW_TESTAMENT,EASY,false);
        entries.add(mQuestion);



        return entries;

    }




/*
        entries.add(mQuestion);mQuestion = new  QuestionsEntry ( "",
                                                                         "","","", "",
                                                                         "","",_TESTAMENT,EASY,false);
        entries.add(mQuestion);


3).

4).

5).


7).

8).

9).
11). At which pool was the man with 38 years of sickness healed
    A. Siloam
    B. Bethesda
    C. Jordan
    D. Bethsaida
12). Which country did the Eunuch come from
    A. Egypt
    B. Jerusalem
    C. Syria
    D. Ethiopia
13) Which prophet prophesied about the dry bones
    A. Isaiah
    B. Jeremiah
    C. Lamentations
    D. Ezekiel
14). The rebuilding of the walls of Jerusalem was done by whom
    A. Sanballat
    B. Esther
    C. Nehemiah
    D. Tobias

15) How many daughters did Job have
    A.  1
    B.  3
    C.  4
    D.  2

    */
}
