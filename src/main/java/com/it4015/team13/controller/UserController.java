package com.it4015.team13.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.it4015.team13.domain.User;
import com.it4015.team13.domain.response.User.ResCreateUserDTO;
import com.it4015.team13.domain.response.User.ResUserDTO;
import com.it4015.team13.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController extends BaseController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<ResCreateUserDTO> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.handleCreateUser(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<ResUserDTO>> GetAllUser() {
        return ResponseEntity.ok(userService.handleFindALlUser());
    }
}
