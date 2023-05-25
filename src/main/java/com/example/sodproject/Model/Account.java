package com.example.sodproject.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {

  @Id
  @Column(name = "user_id")
  private Long userId;
  @Column(name = "question_count")
  private Long questionCount;
  @Column(name = "answer_count")
  private Long answerCount;
  @Column(name = "comment_count")
  private Long commentCount;

  public Account(Long userId, Long questionCount, Long answerCount, Long commentCount) {
    this.userId = userId;
    this.questionCount = questionCount;
    this.answerCount = answerCount;
    this.commentCount = commentCount;
  }

  public Account() {

  }
}
