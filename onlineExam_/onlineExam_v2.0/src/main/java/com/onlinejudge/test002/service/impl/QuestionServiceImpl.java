package com.onlinejudge.test002.service.impl;

import com.onlinejudge.test002.mapper.QuestionMapper;
import com.onlinejudge.test002.pojo.Question;
import com.onlinejudge.test002.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * gyh添加 2024/7/11
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    @Transactional
    public void addQuestion(Question question) {
        questionMapper.insertQuestion(question);
    }

    @Override
    @Transactional
    public void updateQuestion(Question question) {
        questionMapper.updateQuestion(question);
    }

    @Override
    @Transactional
    public void deleteQuestion(Integer id) {
        questionMapper.deleteQuestion(id);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionMapper.getAllQuestions();
    }

    @Override
    public Question getQuestionById(Integer id) {
        return questionMapper.getQuestionById(id);
    }
    @Override
    public List<Question> getRandomQuestionsByCategory(String category) {
        return questionMapper.findRandomQuestionsByCategory(category);
    }

    @Override
    public Question findById(int id) {
        return questionMapper.findById(id);
    }
    @Override
    public String getCorrectAnswerById(int id) {
        return questionMapper.getCorrectAnswerById(id);
    }
}
