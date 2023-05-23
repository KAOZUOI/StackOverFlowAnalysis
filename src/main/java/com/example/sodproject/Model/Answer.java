package com.example.sodproject.Model;

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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long answer_id;
  private Long user_id;
  private Long question_id;
  private Timestamp creation_date;
  private Long up_vote_count;

  public Answer(Long answer_id, Long user_id, Long question_id, Timestamp creation_date,
      Long up_vote_count) {
    this.answer_id = answer_id;
    this.user_id = user_id;
    this.question_id = question_id;
    this.creation_date = creation_date;
    this.up_vote_count = up_vote_count;
  }

  public Answer() {

  }

  public Long getAnswer_id() {
    return answer_id;
  }

  public void setAnswer_id(Long answer_id) {
    this.answer_id = answer_id;
  }

  public Long getUser_id() {
    return user_id;
  }

  public void setUser_id(Long user_id) {
    this.user_id = user_id;
  }

  public Long getQuestion_id() {
    return question_id;
  }

  public void setQuestion_id(Long question_id) {
    this.question_id = question_id;
  }

  public Timestamp getCreation_date() {
    return creation_date;
  }

  public void setCreation_date(Timestamp creation_date) {
    this.creation_date = creation_date;
  }

  public Long getUp_vote_count() {
    return up_vote_count;
  }

  public void setUp_vote_count(Long up_vote_count) {
    this.up_vote_count = up_vote_count;
  }
}
