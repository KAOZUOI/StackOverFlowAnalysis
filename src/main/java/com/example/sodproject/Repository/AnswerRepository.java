package com.example.sodproject.Repository;

import com.example.sodproject.Model.Answer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AnswerRepository extends JpaRepository<Answer, Long> {

  List<Answer> findByAnswerId(Long acceptedAnswerId);

  List<Answer> findByQuestionId(Long questionId);
}