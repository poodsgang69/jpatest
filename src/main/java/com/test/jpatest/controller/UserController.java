package com.test.jpatest.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import com.test.jpatest.exception.DuplicateEmailFoundException;
import com.test.jpatest.exception.DuplicateNameFoundException;
import com.test.jpatest.exception.UserNotFoundException;
import com.test.jpatest.model.User;
import com.test.jpatest.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/user")
    @ResponseBody
    public User newUser(@RequestBody User newUser) {
        String foundName = userRepository.getByName(newUser.getName());
        String foundEmail = userRepository.getByEmail(newUser.getEmail());
        //check if same username / email exists
        if(foundName != null) {
            throw new DuplicateNameFoundException(newUser.getName());
        } else if(foundEmail != null) {
            throw new DuplicateEmailFoundException(newUser.getEmail());
        } else return userRepository.save(newUser);
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers() {
//        return userRepository.findAll();
        String query = "SELECT * from User u";
        List<User> resultSet = this.userRepository.findAll();
        return resultSet;
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> {
                    return new UserNotFoundException(id);
                });
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public List<User> deleteUser(@PathVariable Long id) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> {
//                    return new UserNotFoundException(id);
//                });

        if(!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
//        return "User with id: " + id +" has been deleted successfully.";

        return userRepository.findAll();
    }
}
