package ru.sky.pro.courseWork2.ServiceExam.repository;

import ru.sky.pro.courseWork2.ServiceExam.entity.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
}
