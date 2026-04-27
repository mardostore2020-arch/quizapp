package com.quiz.quizapp.controller;

import com.quiz.quizapp.service.QuizService;
import com.quiz.quizapp.repository.ResultRepository;
import com.quiz.quizapp.model.Result;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class QuizController {

    private final QuizService quizService;
    private final ResultRepository resultRepository;

    public QuizController(QuizService quizService, ResultRepository resultRepository) {
        this.quizService = quizService;
        this.resultRepository = resultRepository;
    }

    // 🔥 ICI TON CODE
    @GetMapping("/quiz")
public String startQuiz(Model model) {
    model.addAttribute("questionIndex", 0);
    model.addAttribute("question", quizService.getAllQuestions().get(0));
    return "quiz";
}

    // 🔥 ENVOI DES RÉPONSES
    @PostMapping("/next")
public String nextQuestion(@RequestParam int questionIndex,
                           @RequestParam String answer,
                           @RequestParam String username,
                           Model model) {

    int nextIndex = questionIndex + 1;

    if (nextIndex >= quizService.getAllQuestions().size()) {
        return "redirect:/result";
    }

    model.addAttribute("questionIndex", nextIndex);
    model.addAttribute("question", quizService.getAllQuestions().get(nextIndex));
    model.addAttribute("username", username);

    return "quiz";
}
}