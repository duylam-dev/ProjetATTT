package com.it4015.team13.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.it4015.team13.domain.User;
import com.it4015.team13.domain.response.ResCreateUserDTO;
import com.it4015.team13.domain.response.ResUserDTO;
import com.it4015.team13.repository.UserRepository;
import com.it4015.team13.util.exception.IdInValidException;
import com.it4015.team13.util.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User handleFindByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("user not exits"));
    }

    public void handleUpdateRefreshToken(String email, String token) {
        var user = handleFindByEmail(email);
        user.setRefreshToken(token);
        userRepository.save(user);
    }

    public ResCreateUserDTO handleCreateUser(User user) throws IdInValidException {
        if (userRepository.existsByEmail(user.getEmail()))
            throw new IdInValidException("email: " + user.getEmail() + "existed, please use other email!");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return UserMapper.toCreateUserDTO(userRepository.save(user));
    }

    public List<ResUserDTO> handleFindAllUser() {
        var users = userRepository.findAll();
        List<ResUserDTO> res = new ArrayList<>();
        for (User user : users) {
            res.add(UserMapper.toResUserDTO(user));
        }

        return res;
    }
}
