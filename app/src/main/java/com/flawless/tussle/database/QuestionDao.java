package com.flawless.tussle.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuestionDao {

    @Query("SELECT COUNT(question) FROM quizQuestion")
    int getAllQuestionsCount();

    @Query("SELECT * FROM quizQuestion ORDER BY question")
    List<QuestionsEntry> loadAllQuestions();

    @Insert
    void addQuestion(QuestionsEntry questionsEntry);
}
