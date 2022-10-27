package ru.sky.pro.courseWork2.ServiceExam.service;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.server.MethodNotAllowedException;
import ru.sky.pro.courseWork2.ServiceExam.entity.Question;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static ru.sky.pro.courseWork2.ServiceExam.utils.Utils.randInt;

@Service
@Order(2)
public class MathQuestionService implements QuestionService {

    private static final List<String> operations = List.of("/", "*", "+", "-");

    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowedException("Метод не доступен", Collections.singleton(HttpMethod.GET));
    }

    @Override
    public Question add(Question question) {
        throw new MethodNotAllowedException("Метод не доступен", Collections.singleton(HttpMethod.GET));
    }

    @Override
    public Question remove(Question question) {
        throw new MethodNotAllowedException("Метод не доступен", Collections.singleton(HttpMethod.GET));
    }

    @Override
    public Question find(Question question) {
        throw new MethodNotAllowedException("Метод не доступен", Collections.singleton(HttpMethod.GET));
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowedException("Метод не доступен", Collections.singleton(HttpMethod.GET));
    }

    @Override
    public Question getRandomQuestion() {
        String action = operations.get(randInt(0,operations.size() - 1));
        int intFirst = randInt(0,10);
        int intSecond = randInt(1,10);
        String process = intFirst + " " + action + " " + intSecond;
        String question = process + " = ?";
        int answer = 0;
        switch (action) {
            case "+" -> answer = intFirst + intSecond;
            case "-" -> answer = intFirst - intSecond;
            case "*" -> answer = intFirst * intSecond;
            case "/" -> answer = intFirst / intSecond;
        }
        return new Question(question, String.valueOf(answer));
    }


}

