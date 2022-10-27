package ru.sky.pro.courseWork2.ServiceExam.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sky.pro.courseWork2.ServiceExam.entity.Question;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {

    JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository();

    Question questionWithNull;
    Question questionWithNull1;
    Question questionWithEmpty;
    Question questionWithEmpty1;
    Question correct = new Question("Java", "1");

    Set<Question> questionsTest = new HashSet<>();

    @BeforeEach
    public void init() {
        questionWithNull = new Question("Java", null);
        questionWithNull1 = new Question(null, "0000");
        questionWithEmpty = new Question("Java", "");
        questionWithEmpty1 = new Question("", "1");
    }

    @Test
    void WithNullAddShouldBeThrowException() {
        assertThrows(IllegalArgumentException.class,() -> javaQuestionRepository.add(null));
        assertThrows(IllegalArgumentException.class,() -> javaQuestionRepository.add(questionWithNull));
        assertThrows(IllegalArgumentException.class,() -> javaQuestionRepository.add(questionWithNull1));
        assertThrows(IllegalArgumentException.class,() -> javaQuestionRepository.add(questionWithEmpty));
        assertThrows(IllegalArgumentException.class,() -> javaQuestionRepository.add(questionWithEmpty1));
    }

    @Test
    void correctTestAdd() {
        assertEquals(correct,javaQuestionRepository.add(correct));
    }

    @Test
    void WithNullRemoveShouldBeThrowException() {
        assertThrows(IllegalArgumentException.class,() -> javaQuestionRepository.remove(null));
        assertThrows(IllegalArgumentException.class,() -> javaQuestionRepository.remove(questionWithNull));
        assertThrows(IllegalArgumentException.class,() -> javaQuestionRepository.remove(questionWithNull1));
        assertThrows(IllegalArgumentException.class,() -> javaQuestionRepository.remove(questionWithEmpty));
        assertThrows(IllegalArgumentException.class,() -> javaQuestionRepository.remove(questionWithEmpty1));
    }

    @Test
    void correctTestRemove() {
        javaQuestionRepository.add(correct);
        assertEquals(correct,javaQuestionRepository.remove(correct));
    }

    @Test
    void getAll() {
        javaQuestionRepository.add(correct);
        questionsTest.add(correct);
        assertThat(javaQuestionRepository.getAll()).hasSize(1).hasSameElementsAs(questionsTest);
    }

}