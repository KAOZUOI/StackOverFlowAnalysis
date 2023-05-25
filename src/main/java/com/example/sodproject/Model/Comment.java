package com.example.sodproject.Model;

import jakarta.persistence.Column;
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
  private Long id;
  @Column(name = "comment_id")
  private Long commentId;
  @Column(name = "post_id")
  private Long postId;
  @Column(name = "user_id")
  private Long userId;

  public Comment(Long commentId, Long postId, Long userId) {
    this.commentId = commentId;
    this.postId = postId;
    this.userId = userId;
  }

  public Comment() {
  }


}
