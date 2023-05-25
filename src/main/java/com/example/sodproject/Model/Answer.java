package com.example.sodproject.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table
public class Answer {

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "answer_id")
  private Long answerId;
  @Column(name = "user_id")
  private Long userId;
  @Column(name = "question_id")
  private Long questionId;
  @Column(name = "creation_date")
  private Timestamp creationDate;
  @Column(name = "up_vote_count")
  private Long upVoteCount;
  @Column(name = "is_accepted")
  private boolean isAccepted;
  @Column(name = "comment_count")
  private Long commentCount;

  public Answer(Long answerId, Long userId, Long questionId, Timestamp creationDate,
      Long upVoteCount, boolean isAccepted, Long commentCount) {
    this.answerId = answerId;
    this.userId = userId;
    this.questionId = questionId;
    this.creationDate = creationDate;
    this.upVoteCount = upVoteCount;
    this.isAccepted = isAccepted;
    this.commentCount = commentCount;
  }

  public Answer() {

  }


}
