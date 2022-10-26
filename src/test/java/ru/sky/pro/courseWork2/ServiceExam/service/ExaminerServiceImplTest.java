package ru.sky.pro.courseWork2.ServiceExam.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sky.pro.courseWork2.ServiceExam.entity.Question;
import ru.sky.pro.courseWork2.ServiceExam.repository.JavaQuestionRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    List<QuestionService> questions;

    @InjectMocks
    ExaminerServiceImpl examinerService;


    @Test
    void getQuestion() {
        JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository();
        javaQuestionRepository.add(new Question("Java", "1"));
        when(questions.get(0)).thenReturn(new JavaServiceImpl(javaQuestionRepository));
        when(questions.get(1)).thenReturn(new MathQuestionService());
        assertEquals(2,examinerService.getQuestion().size());

    }


}