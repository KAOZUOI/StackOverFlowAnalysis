package com.example.sodproject.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Tag {

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "question_id")
  private Long questionId;
  private String tag;

  public Tag(Long questionId, String tag) {
    this.questionId = questionId;
    this.tag = tag;
  }

  public Tag() {

  }
}
