package com.flawless.tussle.database;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "quizQuestion")
public class QuestionsEntry {

    @PrimaryKey(autoGenerate = true)
    private  int id;
    private String question;
    private String optionA;
    private String optionB;

    private String optionC;
    private String optionD;
    private String answer;
    private String biblesource;
    private String category;
    private String level;
    private boolean isLiked;



    @Ignore
    public QuestionsEntry(String question, String mOptionA, String optionB, String optionC, String optionD,
                          String answer, String biblesource, String category, String level, boolean isLiked) {
        this.question = question;
        this.optionA = mOptionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
        this.biblesource = biblesource;
        this.category = category;
        this.level = level;
        this.isLiked = isLiked;
    }

    public QuestionsEntry(int id, String question, String mOptionA, String optionB, String optionC,
                          String optionD, String answer, String biblesource, String category, String level, boolean isLiked) {
        this.id = id;
        this.question = question;
        this.optionA = mOptionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
        this.biblesource = biblesource;
        this.category = category;
        this.level = level;
        this.isLiked = isLiked;
    }



    public QuestionsEntry() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String mOptionA) {
        this.optionA = mOptionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getBiblesource() {
        return biblesource;
    }

    public void setBiblesource(String biblesource) {
        this.biblesource = biblesource;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }
}
