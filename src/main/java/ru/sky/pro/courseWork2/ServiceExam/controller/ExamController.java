package ru.sky.pro.courseWork2.ServiceExam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sky.pro.courseWork2.ServiceExam.entity.Question;
import ru.sky.pro.courseWork2.ServiceExam.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/get")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping()
    public Collection<Question> getQuestion() {
        return examinerService.getQuestion();
    }


}
