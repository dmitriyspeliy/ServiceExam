package ru.sky.pro.courseWork2.ServiceExam.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sky.pro.courseWork2.ServiceExam.entity.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    public Collection<Question> getQuestion(int amount) {
        if (!questions.isEmpty()) questions.clear();
        if(amount >= questionServices.get(0).getAll().size()) throw new IndexOutOfBoundsException();
        int beanIndex = randInt(0, questionServices.size() - 1);
        while (questions.size() <= amount) {
            questions.add(questionServices.get(beanIndex).getRandomQuestion());
        }
        return questions;
    }

    public static int randInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

}
