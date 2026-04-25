package com.quiz.quizapp.repository;

import com.quiz.quizapp.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {

    // 🔥 Classement du meilleur au pire
    List<Result> findAllByOrderByScoreDesc();
}