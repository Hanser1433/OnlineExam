package com.onlinejudge.test002.pojo;

import lombok.Data;

/**
 * gyh添加 2024/7/11
 */
@Data
public class Question {

private Integer id;
private String category;
private String question;
private String type;
private String options;
private String correctAnswer;
}