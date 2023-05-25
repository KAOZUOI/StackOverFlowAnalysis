package com.example.sodproject.Repository;

import com.example.sodproject.Model.Question;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
  Long countByAnswerCount(Long answer_count);
  Long countByAnswerCountGreaterThan(Long answer_count);

}
