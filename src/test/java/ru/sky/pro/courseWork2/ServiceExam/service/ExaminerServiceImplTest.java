package ru.sky.pro.courseWork2.ServiceExam.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sky.pro.courseWork2.ServiceExam.entity.Question;
import ru.sky.pro.courseWork2.ServiceExam.repository.JavaQuestionRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {


    @Mock
    ExaminerServiceImpl examinerService;

    Set<Question> questionTest = new HashSet<>();


    @Test
    void getQuestion() {
        questionTest.add(new Question("1 + 1 =","2"));
        questionTest.add(new Question("Java","1"));
        lenient().when(examinerService.getQuestion()).thenReturn(questionTest);
        //как проверить этот метод...я не знаю

    }


}