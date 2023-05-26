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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getAnswerId() {
    return answerId;
  }

  public void setAnswerId(Long answerId) {
    this.answerId = answerId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getQuestionId() {
    return questionId;
  }

  public void setQuestionId(Long questionId) {
    this.questionId = questionId;
  }

  public Timestamp getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Timestamp creationDate) {
    this.creationDate = creationDate;
  }

  public Long getUpVoteCount() {
    return upVoteCount;
  }

  public void setUpVoteCount(Long upVoteCount) {
    this.upVoteCount = upVoteCount;
  }

  public boolean isAccepted() {
    return isAccepted;
  }

  public void setAccepted(boolean accepted) {
    isAccepted = accepted;
  }

  public Long getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(Long commentCount) {
    this.commentCount = commentCount;
  }
}
