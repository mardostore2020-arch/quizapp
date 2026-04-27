package com.quiz.quizapp.service;

import com.quiz.quizapp.model.Question;
import com.quiz.quizapp.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuizService {

    private final QuestionRepository questionRepository;

    public QuizService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public int calculateScore(Map<String, String> answers) {
        int score = 0;

        List<Question> questions = questionRepository.findAll();

        for (Question q : questions) {
            String key = "q" + q.getId();

            if (answers.containsKey(key) &&
                answers.get(key).equalsIgnoreCase(q.getCorrectOption())) {
                score++;
            }
        }

        return score;
    }
}