package com.example.lab11.Controller;

import com.example.lab11.Api.ApiExeption;
import com.example.lab11.Api.ApiResponse;
import com.example.lab11.Model.User;
import com.example.lab11.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getUser() {
         return ResponseEntity.status(200).body(userService.findAll());
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@Valid@RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }
        userService.add(user);
        return ResponseEntity.status(200).body(new ApiResponse( "User added successfully"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity UpdateUser(@PathVariable Integer id,@Valid @RequestBody User user, Errors errors)  {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }
        userService.update(id,user);
        return ResponseEntity.status(200).body(new ApiResponse( "User updated successfully"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable  Integer id)  {
        userService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("user delete successfully"));

    }
    @GetMapping("/get_user_by_registration_Date/{registrationDate}")
    public ResponseEntity getUserByRegistrationDate(@PathVariable Date registrationDate)  {
        List<User> user1= userService.findUserByRegistrationDate(registrationDate);
        return ResponseEntity.status(200).body(user1);
    }
}
