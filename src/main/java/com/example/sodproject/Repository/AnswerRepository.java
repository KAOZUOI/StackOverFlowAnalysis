package com.example.sodproject.Repository;

import com.example.sodproject.Model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}