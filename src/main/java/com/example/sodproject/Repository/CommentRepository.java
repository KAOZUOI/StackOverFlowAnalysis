package com.example.sodproject.Repository;

import com.example.sodproject.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
