package ru.sky.pro.courseWork2.ServiceExam.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sky.pro.courseWork2.ServiceExam.entity.Question;
import ru.sky.pro.courseWork2.ServiceExam.repository.JavaQuestionRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JavaServiceImplTest {
    @Mock
    JavaQuestionRepository questionRepository;
    @InjectMocks
    JavaServiceImpl javaService;
    Set<Question> questionsTest = new HashSet<>();
    Question questionWithNull;
    Question questionWithNull1;
    Question questionWithEmpty;
    Question questionWithEmpty1;
    Question correct = new Question("Java", "1");

    @BeforeEach
    public void init() {
        questionWithNull = new Question("Java", null);
        questionWithNull1 = new Question(null, "0000");
        questionWithEmpty = new Question("Java", "");
        questionWithEmpty1 = new Question("", "1");
        questionsTest.add(correct);
        lenient().when(javaService.getAll()).thenReturn(questionsTest);
    }

    @Test
    void add() {
        assertEquals(correct, javaService.add(correct));
        verify(questionRepository, times(1)).add(correct);
        assertThrows(IllegalArgumentException.class, () -> javaService.add(questionWithNull));
        assertThrows(IllegalArgumentException.class, () -> javaService.add(questionWithNull1));
        assertThrows(IllegalArgumentException.class, () -> javaService.add(questionWithEmpty));
        assertThrows(IllegalArgumentException.class, () -> javaService.add(questionWithEmpty1));
    }

    @Test
    void remove() {
        assertEquals(correct, javaService.remove(correct));
        verify(questionRepository, times(1)).remove(correct);

        assertThrows(IllegalArgumentException.class, () -> javaService.remove(questionWithNull));
        assertThrows(IllegalArgumentException.class, () -> javaService.remove(questionWithNull1));
        assertThrows(IllegalArgumentException.class, () -> javaService.remove(questionWithEmpty));
        assertThrows(IllegalArgumentException.class, () -> javaService.remove(questionWithEmpty1));
    }

    @Test
    void getAll() {
        assertThat(questionsTest).hasSize(1).hasSameElementsAs(javaService.getAll());
        verify(questionRepository, times(1)).getAll();
    }

    @Test
    void getRandomQuestion() {
        Question question = javaService.getRandomQuestion();
        assertEquals(correct, question);
    }
}
