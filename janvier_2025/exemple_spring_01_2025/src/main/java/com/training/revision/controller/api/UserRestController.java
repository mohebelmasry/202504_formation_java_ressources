package com.training.revision.controller.api;

import com.training.revision.model.User;
import com.training.revision.entity.UserEntity;
import com.training.revision.repository.UserRepository;
import com.training.revision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity fetchAll() {
        List<User> userList = userService.findAll();

        userRepository.save(new UserEntity(UUID.randomUUID(), "BB", "SS"));
        userRepository.save(new UserEntity(UUID.randomUUID(), "AA", "RR"));

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userList);
    }


}
