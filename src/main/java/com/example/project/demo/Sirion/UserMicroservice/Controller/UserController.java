package com.example.project.demo.Sirion.UserMicroservice.Controller;


import com.example.project.demo.Sirion.UserMicroservice.Model.User;
import com.example.project.demo.Sirion.UserMicroservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping(value = "/createUser", headers = "Accept=application/json")
    public void createUser(@RequestBody User user){
        userService.createUser(user);

        if (user.getlORm().equals("m")){
            //Code for creating Mentor from User
        }
    }

    @GetMapping(value = "/{id}", headers = "Accept=application/json")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id){
        User user = userService.getUserById(id);

        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "getAllUsers", headers = "Accept=application/json")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @DeleteMapping(value = "/deleteUser/{id}", headers = "Accept=application/json")
    public void deleteUserById(@PathVariable("id") long id){
        userService.deleteUserById(id);
    }
}
