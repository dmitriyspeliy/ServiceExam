package ru.sky.pro.courseWork2.ServiceExam.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.sky.pro.courseWork2.ServiceExam.entity.Question;

import java.util.*;

@Service
@Getter
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> questionServices;
    private final Set<Question> questions = new HashSet<>();

    @Autowired
    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.questionServices = questionServices;
    }

    @Override
    public Collection<Question> getQuestion() {
        if (!questions.isEmpty()) questions.clear();
        for (int i = 0; i < randInt(1, questionServices.get(0).getAll().size()); i++) {
            questions.add(questionServices.get(1).getRandomQuestion());
            questions.add(questionServices.get(0).getRandomQuestion());
        }
        return questions;
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

}
