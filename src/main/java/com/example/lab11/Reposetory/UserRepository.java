package com.example.lab11.Reposetory;

import com.example.lab11.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findUserById(Integer id);
List<User> findUserByRegistrationDate(Date registrationDate);
}
