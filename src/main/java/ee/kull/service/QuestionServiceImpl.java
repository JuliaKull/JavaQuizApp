package ee.kull.service;

import ee.kull.entity.Question;
import ee.kull.entity.QuestionForm;
import ee.kull.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionServise {

    @Autowired
    private QuestionRepository repository;

    @Override
    public List<Question> getAllQuestions() {
        return repository.findAll();
    }

    @Override
    public List<Question> getQuestionsByTopic(String topic) {
        return repository.findAllByTopic(topic);
    }

    @Override
    public Question saveQuestion(Question question) {
        return repository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return repository.save(question);
    }

    @Override
    public Question getQuestionById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteQuestionById(Long id) {
        repository.deleteById(id);
    }

    public QuestionForm getQuestions() {
        List<Question> allQues = repository.findAll();
        List<Question> qList = new ArrayList<Question>();

        for(int i=0; i<5; i++) {
            int rand = 1 + (int)(Math.random() * ((allQues.size() - 1)));
            qList.add(allQues.get(rand));
            allQues.remove(rand);
        }
        QuestionForm qForm=new QuestionForm();
        qForm.setQuestions(qList);

        return qForm;
    }




}
