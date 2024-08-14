package com.example.lab11.Controller;

import com.example.lab11.Api.ApiResponse;
import com.example.lab11.Model.Post;
import com.example.lab11.Service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping("/get")
    public ResponseEntity getPost(){
        return ResponseEntity.status(200).body(postService.findAll());
    }
    @PostMapping("/add")
    public ResponseEntity addPost(@Valid@RequestBody Post post, Errors errors){
        if(errors.hasErrors()){
String errorMessage = errors.getFieldError().getDefaultMessage();
return ResponseEntity.status(400).body(errorMessage);
        }
        postService.addPost(post);
        return ResponseEntity.status(200).body(new ApiResponse("post added"));


    }
    @PutMapping("/update/{id}")
    public ResponseEntity updatePost(@PathVariable Integer id,@Valid@RequestBody Post post, Errors errors){
        if(errors.hasErrors()){
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        postService.updatePost(id, post);
        return ResponseEntity.status(200).body(new ApiResponse("post updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id){
        postService.deletePost(id);
        return ResponseEntity.status(200).body("post deleted");
    }
    @GetMapping("/getpostbyuserid/{userId}")
    public ResponseEntity findPostByUserId(@PathVariable Integer userId){
        return ResponseEntity.status(200).body(postService.findPostByUserId(userId));
    }
    @GetMapping("/get_post_by_title/{title}")
    public ResponseEntity findPostByTitle(@PathVariable String title){
        return ResponseEntity.status(200).body(postService.findPostByTitle(title));
    }
    @GetMapping("/p_date/{date}")
    public ResponseEntity findpostBuPublishdataAndBefore(@PathVariable Date date){
        return ResponseEntity.status(200).body(postService.findpostBuPublishdataAndBefore(date));
    }
    @GetMapping("/get_post_by_category_id/{categoryId}")
    public ResponseEntity findPostByCategoryId(Integer categoryId){
        return ResponseEntity.status(200).body(postService.findPostByCategoryId(categoryId));

    }
}
