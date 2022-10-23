package ru.sky.pro.courseWork2.ServiceExam.service;

import ru.sky.pro.courseWork2.ServiceExam.entity.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion();
}
