package com.onlinejudge.test002.service;

import com.onlinejudge.test002.pojo.Question;

import java.util.List;

/**
 * gyh添加 2024/7/11
 */
public interface QuestionService {
    void addQuestion(Question question);
    void updateQuestion(Question question);
    void deleteQuestion(Integer id);
    List<Question> getAllQuestions();
    Question getQuestionById(Integer id);
    List<Question> getRandomQuestionsByCategory(String category);
    Question findById(int id);
    String getCorrectAnswerById(int id);
}
