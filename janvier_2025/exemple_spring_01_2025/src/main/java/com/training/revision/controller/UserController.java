package com.training.revision.controller;

import com.training.revision.service.UserService;
import com.training.revision.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String displayUsers(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("users", userList);
        return "users.html";
    }
}
