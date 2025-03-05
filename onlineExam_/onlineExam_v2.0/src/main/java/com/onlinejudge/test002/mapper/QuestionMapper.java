package com.onlinejudge.test002.mapper;

import com.onlinejudge.test002.pojo.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * gyh添加 2024/7/11
 */
@Mapper
public interface QuestionMapper {

    @Insert("INSERT INTO questions (category, question, type, options, correct_answer) VALUES (#{category}, #{question}, #{type}, #{options}, #{correctAnswer})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertQuestion(Question question);

    @Update("UPDATE questions SET category = #{category}, question = #{question}, type = #{type}, options = #{options}, correct_answer = #{correctAnswer} WHERE id = #{id}")
    void updateQuestion(Question question);

    @Delete("DELETE FROM questions WHERE id = #{id}")
    void deleteQuestion(Integer id);

    @Select("SELECT * FROM questions")
    List<Question> getAllQuestions();

    @Select("SELECT * FROM questions WHERE id = #{id}")
    Question getQuestionById(Integer id);

    @Select("SELECT * FROM questions WHERE category = #{category} ORDER BY RAND() LIMIT 5")
    List<Question> findRandomQuestionsByCategory(String category);

    @Select("SELECT * FROM questions WHERE id = #{id}")
    Question findById(int id);

    @Select("SELECT correct_answer FROM questions WHERE id = #{id}")
    String getCorrectAnswerById(int id);

}

