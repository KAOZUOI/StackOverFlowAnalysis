package com.example.sodproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {

  @Id
  private Long user_id;
  private Long question_count;
  private Long answer_count;
  private Long comment_count;

  public Account(Long user_id, Long question_count, Long answer_count, Long comment_count) {
    this.user_id = user_id;
    this.question_count = question_count;
    this.answer_count = answer_count;
    this.comment_count = comment_count;
  }

  public Account() {

  }

  public Long getUser_id() {
    return user_id;
  }

  public void setUser_id(Long user_id) {
    this.user_id = user_id;
  }

  public Long getQuestion_count() {
    return question_count;
  }

  public void setQuestion_count(Long question_count) {
    this.question_count = question_count;
  }

  public Long getAnswer_count() {
    return answer_count;
  }

  public void setAnswer_count(Long answer_count) {
    this.answer_count = answer_count;
  }

  public Long getComment_count() {
    return comment_count;
  }

  public void setComment_count(Long comment_count) {
    this.comment_count = comment_count;
  }
}
