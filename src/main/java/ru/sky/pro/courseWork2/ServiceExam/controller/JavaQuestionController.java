package ru.sky.pro.courseWork2.ServiceExam.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sky.pro.courseWork2.ServiceExam.entity.Question;
import ru.sky.pro.courseWork2.ServiceExam.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService javaService;

    public JavaQuestionController(@Qualifier("javaServiceImpl") QuestionService javaService) {
        this.javaService = javaService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam(value = "question") String question,
                                @RequestParam(value = "answer") String answer) {
        return javaService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam(value = "question") String question,
                                   @RequestParam(value = "answer") String answer) {
        return javaService.remove(new Question(question, answer));
    }

    @GetMapping("/find")
    public Question findQuestion(Question question) {
        return javaService.find(question);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return javaService.getAll();
    }


}
