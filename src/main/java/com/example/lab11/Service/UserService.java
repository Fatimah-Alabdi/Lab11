package com.example.lab11.Service;

import com.example.lab11.Api.ApiExeption;
import com.example.lab11.Model.User;
import com.example.lab11.Reposetory.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }
    public void add(User user) {
        userRepository.save(user);
    }
    public void update(Integer id,User user)  {
        User u=userRepository.findUserById(id);
        if(u == null) {
            throw new ApiExeption("no user found");
        }

            u.setUsername(user.getUsername());
            u.setPassword(user.getPassword());
            u.setEmail(user.getEmail());
            u.setRegistrationDate(user.getRegistrationDate());
            userRepository.save(u);

    }
    public void delete(Integer id)  {
        User u=userRepository.findUserById(id);
        if(u == null) {
            throw new ApiExeption("no user found");
        }
        userRepository.delete(u);
    }
    public User findUserById(Integer id) {
        return userRepository.findUserById(id);
    }
    public List<User> findUserByRegistrationDate(Date registrationDate) {
        return userRepository.findUserByRegistrationDate(registrationDate);

    }
}
