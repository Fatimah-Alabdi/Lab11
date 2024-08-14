package com.example.lab11.Reposetory;

import com.example.lab11.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentReposetory extends JpaRepository<Comment,Integer> {
    Comment findCommentById(Integer id);
   List<Comment> findCommentByPostId(Integer postId);

   Comment findCommentByPostIdAndUserId(Integer postId, Integer userId);
}
