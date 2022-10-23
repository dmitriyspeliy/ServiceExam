package ru.sky.pro.courseWork2.ServiceExam.service;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.MethodNotAllowedException;
import ru.sky.pro.courseWork2.ServiceExam.entity.Question;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionServiceTest {

    MathQuestionService mathQuestionService = new MathQuestionService();

    Question test = new Question("Math","1");

    @Test
    void add() {
        assertThrows(MethodNotAllowedException.class, () -> mathQuestionService.add(test));
    }

    @Test
    void remove() {
        assertThrows(MethodNotAllowedException.class, () -> mathQuestionService.remove(test));
    }

    @Test
    void getAll() {
        assertThrows(MethodNotAllowedException.class, () -> mathQuestionService.getAll());
    }

    @Test
    void getRandomQuestion() {
        Question question = mathQuestionService.getRandomQuestion();
        String result = question.getQuestion();
        assertTrue(StringUtils.containsAny(result,"+","/","*","-"));
        Pattern NUMBER_MATCHER =
                Pattern.compile("\\d+");
        Matcher matcher = NUMBER_MATCHER.matcher(result);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        assertEquals(2,count);
    }
}