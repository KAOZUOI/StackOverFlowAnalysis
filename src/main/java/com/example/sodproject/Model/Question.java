package com.example.sodproject.Model;


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
  private Long question_id;
  private Long user_id;
  private Long answer_count;
  private Long accepted_answer_id;
  private Timestamp creation_date;
  private Long up_vote_count;
  private Long view_count;

  public Question(Long question_id, Long user_id, Long answer_count, Long accepted_answer_id,
      Timestamp creation_date, Long up_vote_count, Long view_count) {
    this.question_id = question_id;
    this.user_id = user_id;
    this.answer_count = answer_count;
    this.accepted_answer_id = accepted_answer_id;
    this.creation_date = creation_date;
    this.up_vote_count = up_vote_count;
    this.view_count = view_count;
  }

  public Question() {

  }

  public Question(long questionId, long user_id) {
    this.question_id = questionId;
    this.user_id = user_id;
  }


  public Long getQuestion_id() {
    return question_id;
  }

  public void setQuestion_id(Long question_id) {
    this.question_id = question_id;
  }

  public Long getUser_id() {
    return user_id;
  }

  public void setUser_id(Long user_id) {
    this.user_id = user_id;
  }

  public Long getAnswer_count() {
    return answer_count;
  }

  public void setAnswer_count(Long answer_count) {
    this.answer_count = answer_count;
  }

  public Long getAccepted_answer_id() {
    return accepted_answer_id;
  }

  public void setAccepted_answer_id(Long accepted_answer_id) {
    this.accepted_answer_id = accepted_answer_id;
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

  public Long getView_count() {
    return view_count;
  }

  public void setView_count(Long view_count) {
    this.view_count = view_count;
  }
}
