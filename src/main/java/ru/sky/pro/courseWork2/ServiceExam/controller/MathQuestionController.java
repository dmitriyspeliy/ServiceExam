package ru.sky.pro.courseWork2.ServiceExam.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sky.pro.courseWork2.ServiceExam.entity.Question;
import ru.sky.pro.courseWork2.ServiceExam.service.QuestionService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    private final QuestionService mathQuestionService;


    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService javaService) {
        this.mathQuestionService = javaService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam(value = "question") String question,
                                @RequestParam(value = "answer") String answer) {
        return mathQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam(value = "question") String question,
                                   @RequestParam(value = "answer") String answer) {
        return mathQuestionService.remove(new Question(question, answer));
    }

    @GetMapping("/find")
    public Question findQuestion(Question question) {
        return mathQuestionService.find(question);
    }

    @GetMapping
    public Question getQuestions() {
        return mathQuestionService.getRandomQuestion();
    }


}
