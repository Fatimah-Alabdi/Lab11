package com.example.lab11.Reposetory;

import com.example.lab11.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostReposetory extends JpaRepository<Post, Integer> {
    Post findPostById(Integer id);
    List<Post> findPostByUserId(Integer userId);
     Post findPostByTitle(String title);
@Query("select p from Post p where p.publishDate<=?1")
    List<Post> searchPostByPublishDateAndPublishDateBefore(Date date);

List<Post> findPostByCategoryId(Integer categoryId);


}

