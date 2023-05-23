package com.example.sodproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Comment {

  @Id
  @GeneratedValue
  private Long comment_id;
  private Long post_id;
  private Long user_id;

  public Comment(Long comment_id, Long post_id, Long user_id) {
    this.comment_id = comment_id;
    this.post_id = post_id;
    this.user_id = user_id;
  }

  public Comment() {
  }

  public Long getComment_id() {
    return comment_id;
  }

  public void setComment_id(Long comment_id) {
    this.comment_id = comment_id;
  }

  public Long getPost_id() {
    return post_id;
  }

  public void setPost_id(Long post_id) {
    this.post_id = post_id;
  }

  public Long getUser_id() {
    return user_id;
  }

  public void setUser_id(Long user_id) {
    this.user_id = user_id;
  }
}
