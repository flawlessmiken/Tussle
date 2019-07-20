package com.flawless.tussle.model;

public class ReviewModel {

    private String Question;
    private String RightAnswer;
    private String WrongAnswer;

    public ReviewModel(String question, String rightAnswer, String wrongAnswer) {

        Question = question;
        RightAnswer = rightAnswer;
        WrongAnswer = wrongAnswer;
    }

    public ReviewModel() {
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getRightAnswer() {
        return RightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        RightAnswer = rightAnswer;
    }

    public String getWrongAnswer() {
        return WrongAnswer;
    }

    public void setWrongAnswer(String wrongAnswer) {
        WrongAnswer = wrongAnswer;
    }
}
