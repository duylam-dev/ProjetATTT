package com.it4015.team13.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.it4015.team13.domain.User;
import com.it4015.team13.domain.response.ResCreateUserDTO;
import com.it4015.team13.domain.response.ResUserDTO;
import com.it4015.team13.service.UserService;
import com.it4015.team13.util.exception.IdInValidException;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController extends BaseController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<ResCreateUserDTO> createUser(@RequestBody User user) throws IdInValidException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.handleCreateUser(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<ResUserDTO>> getAllUser() {
        return ResponseEntity.ok(userService.handleFindAllUser());
    }

}
