package com.it4015.team13.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.it4015.team13.domain.request.ReqLoginDTO;
import com.it4015.team13.domain.response.ResLoginDTO;
import com.it4015.team13.service.AuthenticationService;
import com.it4015.team13.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController extends BaseController {
        private final AuthenticationService authenticationService;
        private final UserService userService;

        @Value("${team13.jwt.refresh-token-validity-in-seconds}")
        private long refreshToken_expired;

        @PostMapping("/auth/login")
        public ResponseEntity<ResLoginDTO> login(@RequestBody ReqLoginDTO request) {

                var res = authenticationService.authentication(request);

                ResponseCookie cookie = ResponseCookie
                                .from("refresh_token", userService.handleFindByEmail(
                                                res.getUserLogin().getEmail()).getRefreshToken())
                                .httpOnly(true)
                                .secure(true)
                                .path("/")
                                .maxAge(refreshToken_expired)
                                .build();

                return ResponseEntity.ok()
                                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                                .body(res);
        }
}
