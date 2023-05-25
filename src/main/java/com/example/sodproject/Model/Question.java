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
public class Question {

  @Id
  @Column(name = "question_id")
  private Long questionId;
  @Column(name = "user_id")
  private Long userId;
  @Column(name = "answer_count")
  private Long answerCount;
  @Column(name = "accepted_answer_id")
  private Long acceptedAnswerId;
  @Column(name = "creation_date")
  private Timestamp creationDate;
  @Column(name = "up_vote_count")
  private Long upVoteCount;
  @Column(name = "view_count")
  private Long viewCount;
  @Column(name = "comment_count")
  private Long commentCount;

  public Question(Long questionId, Long userId, Long answerCount, Long acceptedAnswerId,
      Timestamp creationDate, Long upVoteCount, Long viewCount, Long commentCount) {
    this.questionId = questionId;
    this.userId = userId;
    this.answerCount = answerCount;
    this.acceptedAnswerId = acceptedAnswerId;
    this.creationDate = creationDate;
    this.upVoteCount = upVoteCount;
    this.viewCount = viewCount;
    this.commentCount = commentCount;
  }


  public Question() {

  }

  public Long getQuestionId() {
    return questionId;
  }

  public void setQuestionId(Long questionId) {
    this.questionId = questionId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getAnswerCount() {
    return answerCount;
  }

  public void setAnswerCount(Long answerCount) {
    this.answerCount = answerCount;
  }

  public Long getAcceptedAnswerId() {
    return acceptedAnswerId;
  }

  public void setAcceptedAnswerId(Long acceptedAnswerId) {
    this.acceptedAnswerId = acceptedAnswerId;
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

  public Long getViewCount() {
    return viewCount;
  }

  public void setViewCount(Long viewCount) {
    this.viewCount = viewCount;
  }

  public Long getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(Long commentCount) {
    this.commentCount = commentCount;
  }
}
