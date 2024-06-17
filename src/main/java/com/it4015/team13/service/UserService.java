package com.it4015.team13.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.it4015.team13.domain.User;
import com.it4015.team13.domain.response.User.ResCreateUserDTO;
import com.it4015.team13.domain.response.User.ResUserDTO;
import com.it4015.team13.repository.UserRepository;
import com.it4015.team13.util.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public User handleFindByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("user not exits"));
    }

    public void handleUpdateRefreshToken(String email, String token) {
        var user = handleFindByEmail(email);
        user.setRefreshToken(token);
        userRepository.save(user);
    }

    public ResCreateUserDTO handleCreateUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userMapper.toResCreateDTO(user);
    }

    public List<ResUserDTO> handleFindALlUser() {
        var users = userRepository.findAll();
        List<ResUserDTO> res = new ArrayList<>();
        users.forEach(user -> {
            res.add(userMapper.toResUserDTO(user));
        });

        return res;
    }
}
