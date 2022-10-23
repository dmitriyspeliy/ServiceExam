package ru.sky.pro.courseWork2.ServiceExam.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import ru.sky.pro.courseWork2.ServiceExam.entity.Question;
import ru.sky.pro.courseWork2.ServiceExam.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;


@Service
@Getter
@Order(1)
public class JavaServiceImpl implements QuestionService {
    private final Random random;

    private final QuestionRepository javaQuestionRepository;

    public JavaServiceImpl(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository) {
        this.javaQuestionRepository = questionRepository;
        random = new Random();
    }

    @Override
    public Question add(String question, String answer) {
        checkString(question, answer);
        Question createQuestion = new Question(question, answer);
        javaQuestionRepository.add(createQuestion);
        return createQuestion;
    }

    @Override
    public Question add(Question question) {
        checkString(question.getQuestion(), question.getAnswer());
        javaQuestionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        checkString(question.getQuestion(), question.getAnswer());
        javaQuestionRepository.remove(question);
        return question;
    }

    @Override
    public Question find(Question question) {
        ArrayList<Question> arr = new ArrayList<>(javaQuestionRepository.getAll());
        boolean check = arr.stream().anyMatch(x -> x.equals(question));
        if (check) {
            return arr.stream().filter(x -> x.equals(question)).findFirst().get();
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        int size = javaQuestionRepository.getAll().size();
        if (size < 1) try {
            throw new Exception("Нет элементов в списке");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int randomInt = random.nextInt(size);
        ArrayList<Question> arr = new ArrayList<>(javaQuestionRepository.getAll());
        return arr.get(randomInt);
    }

    private void checkString(String question, String answer) {
        if (answer == null || question == null || answer.isBlank() || question.isBlank()) throw new IllegalArgumentException();
    }
}
