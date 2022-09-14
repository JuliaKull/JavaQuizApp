package ee.kull.service;

import ee.kull.entity.Question;
import ee.kull.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class QuestionServiceImplTest {

    @Mock
    QuestionRepository repository;

    @InjectMocks
    QuestionServiceImpl service;



    @Test
    void getAllQuestionsFromRepository() {
        List<Question> list = new ArrayList<>();
        list.add(new Question());
        given(repository.findAll()).willReturn(list);

        List<Question> expectedList = service.getAllQuestions();

        assertEquals(expectedList, list);
        verify(repository).findAll();
    }

    @Test
    void getQuestionsByTopicIfItExist() {
        Question question  = Question.builder()
                .id(1l)
                .topic("Core")
                .rank("Easy")
                .title("Title")
                .answerA("A")
                .answerB("B")
                .answerC("C")
                .build();
        List<Question> list = new ArrayList<>();
        list.add(question);

        given(repository.findAllByTopic(question.getTopic())).willReturn(list);

        List<Question> expectedQuestions = service.getQuestionsByTopic(question.getTopic());

        assertThat(expectedQuestions).isSameAs(list);

        verify(repository).findAllByTopic(question.getTopic());
    }

    @Test
    void saveQuestionAndReturnFromRepository() {
        Question question  = Question.builder()
                .id(1l)
                .topic("Core")
                .rank("Easy")
                .title("Title")
                .answerA("A")
                .answerB("B")
                .answerC("C")
                .build();
        when(repository.save(ArgumentMatchers.any(Question.class))).thenReturn(question);
        Question createdQuestion = service.saveQuestion(question);

        assertThat(createdQuestion.getTopic()).isSameAs(question.getTopic());
        assertThat(createdQuestion.getRank()).isSameAs(question.getRank());
        assertThat(createdQuestion.getTitle()).isSameAs(question.getTitle());

        verify(repository).save(question);
    }

    @Test
    void whenGivenIdShouldUpdateQuestionIfExist() {
        Question question  = Question.builder()
                .id(1l)
                .topic("Core")
                .rank("Easy")
                .title("Title")
                .answerA("A")
                .answerB("B")
                .answerC("C")
                .build();
        when(repository.findById(question.getId())).thenReturn(Optional.of(question));

        Question questionUpdated=service.getQuestionById(question.getId());
        questionUpdated.setTitle("New Test");

        given(repository.findById(question.getId())).willReturn(Optional.of(question));

        service.updateQuestion(questionUpdated);
        verify(repository).save(questionUpdated);
        verify(repository).findById(question.getId());
    }

    @Test
    void getQuestionByIdIfItExist() {
        Question question  = Question.builder()
                .id(1l)
                .topic("Core")
                .rank("Easy")
                .title("Title")
                .answerA("A")
                .answerB("B")
                .answerC("C")
                .build();

        when(repository.findById(question.getId())).thenReturn(Optional.of(question));

        Question expectedQuestion = service.getQuestionById(question.getId());

        assertThat(expectedQuestion).isSameAs(question);

        verify(repository).findById(question.getId());

    }

    @Test
    void deleteQuestionById() {

        Question question  = Question.builder()
                .id(1l)
                .topic("Core")
                .rank("Easy")
                .title("Title")
                .answerA("A")
                .answerB("B")
                .answerC("C")
                .build();
        when(repository.findById(question.getId())).thenReturn(Optional.of(question));

        service.deleteQuestionById(question.getId());

        verify(repository).deleteById(question.getId());
    }

    @Test
    void getQuestions() {
        Question question  = Question.builder()
                .id(1l)
                .topic("Core")
                .rank("Easy")
                .title("Title")
                .answerA("A")
                .answerB("B")
                .answerC("C")
                .build();
        List<Question> list = new ArrayList<>();
        list.add(question);

        given(repository.findAll()).willReturn(list);

        List<Question> expectedQuestions = service.getAllQuestions();

        assertThat(expectedQuestions).isSameAs(list);

        verify(repository).findAll();
    }
}