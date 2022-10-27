package ru.sky.pro.courseWork2.ServiceExam.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.sky.pro.courseWork2.ServiceExam.entity.Question;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Getter
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> questionServices;
    private final Set<Question> questions = new HashSet<>();

    private final static ThreadLocalRandom random = ThreadLocalRandom.current();

    @Autowired
    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.questionServices = questionServices;
    }

    @Override
    public Collection<Question> getQuestion() {
        if (!questions.isEmpty()) questions.clear();
        int count = questionServices.get(0).getAll().size();
        int beanIndex = randInt(0,questionServices.size() - 1);
        while (questions.size() <= count){
            questions.add(questionServices.get(beanIndex).getRandomQuestion());
        }
        return questions;
    }

    public static int randInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

}
