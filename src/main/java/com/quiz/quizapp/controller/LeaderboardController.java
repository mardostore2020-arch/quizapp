package com.quiz.quizapp.controller;

import com.quiz.quizapp.repository.ResultRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LeaderboardController {

    private final ResultRepository resultRepository;

    public LeaderboardController(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @GetMapping("/leaderboard")
    public String leaderboard(Model model) {
        model.addAttribute("results", resultRepository.findAllByOrderByScoreDesc());
        return "leaderboard";
    }
}