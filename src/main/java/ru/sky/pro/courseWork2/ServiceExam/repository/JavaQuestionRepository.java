package ru.sky.pro.courseWork2.ServiceExam.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import ru.sky.pro.courseWork2.ServiceExam.entity.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
@Getter
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public JavaQuestionRepository() {
        questions = new HashSet<>();
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;

    }

    @PostConstruct
    public void init() {
        questions.add(new Question("Java", "1"));
        questions.add(new Question("Java", "2"));
        questions.add(new Question("Java", "3"));
        questions.add(new Question("Java", "4"));
        questions.add(new Question("Java", "5"));
        questions.add(new Question("Java", "6"));
        questions.add(new Question("Java", "7"));
        questions.add(new Question("Java", "8"));
        questions.add(new Question("Java", "9"));
        questions.add(new Question("Java", "10"));
        questions.add(new Question("Java", "11"));
    }
}
