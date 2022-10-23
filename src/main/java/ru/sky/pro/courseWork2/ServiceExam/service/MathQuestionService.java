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

@Service
@Order(2)
public class MathQuestionService implements QuestionService {

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
        List<String> arr = List.of("/", "*", "+", "-");
        String action = arr.get(randInt(0,arr.size() - 1));
        int intFirst = randInt(0,10);
        int intSecond = randInt(1,10);
        String process = intFirst + " " + action + " " + intSecond;
        String question = process + " = ?";
        int answer = 0;
        if (process.contains("+")) {
            answer = intFirst + intSecond;
        } else if (process.contains("-")) {
            answer = intFirst - intSecond;
        } else if (process.contains("*")) {
            answer = intFirst * intSecond;
        } else {
            answer = intFirst / intSecond;
        }
        return new Question(question, String.valueOf(answer));
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

}

