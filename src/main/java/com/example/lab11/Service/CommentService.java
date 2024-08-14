package com.example.lab11.Service;

import com.example.lab11.Api.ApiExeption;
import com.example.lab11.Model.Category;
import com.example.lab11.Model.Comment;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.User;
import com.example.lab11.Reposetory.CategoryRepository;
import com.example.lab11.Reposetory.CommentReposetory;
import com.example.lab11.Reposetory.PostReposetory;
import com.example.lab11.Reposetory.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentReposetory commentReposetory;
    private final UserRepository userRepository;
    private final PostReposetory postReposetory;

    public List<Comment> findAll(){
        return (List<Comment>) commentReposetory.findAll();
    }
    public void addcomment(Comment comment){
        User u= userRepository.findUserById(comment.getUserId());
        if(u==null){
            throw new ApiExeption("user not found");
        }
        Post post = postReposetory.findPostById(comment.getPostId());
        if(post==null){
            throw new ApiExeption("post not found");
        }
        commentReposetory.save(comment);

    }
    public void updatecomment(Integer id,Comment comment){
        User u= userRepository.findUserById(id);
        if(u==null){
            throw new ApiExeption("user not found");
        }
        Post post = postReposetory.findPostById(id);
        if(post==null){
            throw new ApiExeption("post not found");
        }
        Comment comment1=commentReposetory.findCommentById(id);
        if(comment1==null){
            throw new ApiExeption("comment not found");
        }
        comment1.setCommentDate(comment.getCommentDate());
        comment1.setContent(comment.getContent());
        comment1.setPostId(comment.getPostId());
        comment1.setUserId(comment.getUserId());
        commentReposetory.save(comment1);
    }
    public void deletecomment(Integer id){
       Comment comment=commentReposetory.findCommentById(id);
       if(comment==null){
           throw new ApiExeption("comment not found");
       }
       commentReposetory.delete(comment);
    }
    public List<Comment> findCommentByPostId(Integer postId){
        List<Comment> c=commentReposetory.findCommentByPostId(postId);
        return c;

    }
    public  Comment findCommentByIdPostIdandUserId(Integer PostId,Integer userId){

        Comment c =commentReposetory.findCommentByPostIdAndUserId(PostId,userId);
        return c;
    }
}
