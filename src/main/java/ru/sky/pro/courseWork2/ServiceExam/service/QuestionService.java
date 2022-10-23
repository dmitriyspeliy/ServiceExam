package ru.sky.pro.courseWork2.ServiceExam.service;

import ru.sky.pro.courseWork2.ServiceExam.entity.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Question find(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
