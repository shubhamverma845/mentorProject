package com.example.project.demo.Sirion.UserMicroservice.Controller;


import com.example.project.demo.Sirion.UserMicroservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;


}
