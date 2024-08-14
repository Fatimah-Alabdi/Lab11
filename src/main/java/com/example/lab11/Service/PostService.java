package com.example.lab11.Service;

import com.example.lab11.Api.ApiExeption;
import com.example.lab11.Model.Category;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.User;
import com.example.lab11.Reposetory.CategoryRepository;
import com.example.lab11.Reposetory.PostReposetory;
import com.example.lab11.Reposetory.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostReposetory postReposetory;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final CategoryServicve categoryServicve;
    private final UserService userService;
    public List<Post> findAll(){
        return postReposetory.findAll();
    }
    public void addPost( Post post){
        User u= userRepository.findUserById(post.getUserId());
        if (u==null){
            throw new ApiExeption("user not found");
        }
        Category c = categoryRepository.findCategoryById(post.getCategoryId());
        if (c==null){
            throw new ApiExeption("category not found");
        }
        postReposetory.save(post);


    }
    public void updatePost(Integer id, Post post){
        Category c = categoryRepository.findCategoryById(post.getCategoryId());
        if(c == null){
            throw new ApiExeption("category not found");
        }
        User u= userRepository.findUserById(post.getUserId());
        if(u == null){
            throw new ApiExeption("user not found");
        }
        Post p = postReposetory.findPostById(id);
        if(p == null){
            throw new ApiExeption("post not found");
        }
        p.setTitle(post.getTitle());
        p.setContent(post.getContent());
        p.setCategoryId(post.getCategoryId());
        p.setUserId(post.getUserId());
        p.setPublishDate(post.getPublishDate());
        postReposetory.save(p);

    }
    public void deletePost(Integer id){
        Post p = postReposetory.findPostById(id);
        if(p == null){
            throw new ApiExeption("post not found");
        }
        postReposetory.delete(p);
    }
    public List<Post> findPostByUserId(Integer userId){
        return postReposetory.findPostByUserId(userId);

    }
    public Post findPostByTitle(String title){
        return postReposetory.findPostByTitle(title);

    }
    public List<Post> findpostBuPublishdataAndBefore(Date publishDate){
        return postReposetory.searchPostByPublishDateAndPublishDateBefore(publishDate);

    }
    public List<Post> findPostByCategoryId(Integer categoryId){
        return postReposetory.findPostByCategoryId(categoryId);

    }
}
