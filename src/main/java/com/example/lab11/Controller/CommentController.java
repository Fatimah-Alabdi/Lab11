package com.example.lab11.Controller;

import com.example.lab11.Api.ApiResponse;
import com.example.lab11.Model.Comment;
import com.example.lab11.Service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @GetMapping("/get")
    public ResponseEntity getComment(){
        return ResponseEntity.status(200).body(commentService.findAll());
    }
    @PostMapping("/add")
    public  ResponseEntity addComment(@Valid@RequestBody Comment comment, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        commentService.addcomment(comment);
        return ResponseEntity.status(200).body(new ApiResponse("add comment success"));

    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity deleteComment(@PathVariable Integer id){
        commentService.deletecomment(id);
        return ResponseEntity.status(200).body(new ApiResponse("delete comment success"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id,@Valid @RequestBody Comment comment, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);

        }
        commentService.updatecomment(id, comment);
        return ResponseEntity.status(200).body(new ApiResponse("update comment success"));
    }
    @GetMapping("/get_comment_by_postid/{postId}")
    public ResponseEntity findCommentByPostId(Integer postId){
        return ResponseEntity.status(200).body(commentService.findCommentByPostId(postId));

    }
    @GetMapping("/find_comment_by_postid_userid/{postId}/{userId}")
    public ResponseEntity findCommentByIdPostIdandUserId(@PathVariable Integer postId,@PathVariable Integer userId){
        return ResponseEntity.status(200).body(commentService.findCommentByIdPostIdandUserId(postId,userId));
    }
}
