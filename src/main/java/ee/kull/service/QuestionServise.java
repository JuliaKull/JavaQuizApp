package ee.kull.service;

import ee.kull.entity.Question;

import java.util.List;

public interface QuestionServise {

    List<Question> getAllQuestions();
    List<Question> getQuestionsByTopic(String topic);

    Question saveQuestion(Question question);

    Question updateQuestion(Question question);

    Question getQuestionById(Long id);

    void deleteQuestionById(Long id);




}
