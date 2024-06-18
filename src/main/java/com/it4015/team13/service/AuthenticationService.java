package com.it4015.team13.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.it4015.team13.domain.User;
import com.it4015.team13.domain.request.ReqLoginDTO;
import com.it4015.team13.domain.response.ResLoginDTO;
import com.it4015.team13.util.SecurityUtil;
import com.it4015.team13.util.exception.IdInValidException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtEncoder jwtEncoder;
    private final UserService userService;
    private final JwtDecoder jwtDecoder;

    @Value("${team13.jwt.access-token-validity-in-seconds}")
    private long accessToken_expired;
    @Value("${team13.jwt.refresh-token-validity-in-seconds}")
    private long refreshToken_expired;

    public ResLoginDTO refreshToken(String refreshToken) throws IdInValidException {
        var rs = new ResLoginDTO();
        if (refreshToken.equals("error"))
            throw new IdInValidException("cookie haven't refresh token");
        Jwt token = jwtDecoder.decode(refreshToken);

        String email = token.getSubject();
        // check user
        userService.handleFindByEmail(email);
        // issue thong tin va generate access token
        var userLogin = fetchInfoUserLogin(email);
        rs.setUserLogin(userLogin);
        String accessToken = generateToken(email, false, userLogin);
        rs.setAccessToken(accessToken);
        return rs;
    }

    public ResLoginDTO authentication(ReqLoginDTO request) {
        var rs = new ResLoginDTO();
        // create token to authentication
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getPassword());
        // authentication
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        // set to security contex
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // get info user login
        var userLogin = fetchInfoUserLogin(authentication.getName());
        rs.setUserLogin(userLogin);
        // generate token
        String accessToken = generateToken(authentication.getName(), false, userLogin);
        rs.setAccessToken(accessToken);
        String refreshToken = generateToken(authentication.getName(), true, userLogin);
        userService.handleUpdateRefreshToken(authentication.getName(), refreshToken);
        return rs;
    }

    private String generateToken(String email, boolean isRefresh, ResLoginDTO.UserLogin user) {

        Instant now = Instant.now();
        Instant validity = isRefresh ? now.plus(this.refreshToken_expired, ChronoUnit.SECONDS)
                : now.plus(this.accessToken_expired, ChronoUnit.SECONDS);

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .subject(email)
                .issuedAt(now)
                .issuer("team 13")
                .expiresAt(validity)
                .claim("user", user)
                .build();
        // tao chu ky
        JwsHeader jwsHeader = JwsHeader.with(SecurityUtil.JWT_ALGORITHM).build();
        return jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, claims)).getTokenValue();
    }

    private ResLoginDTO.UserLogin fetchInfoUserLogin(String email) {
        User currentUserDB = userService.handleFindByEmail(email);
        var userLogin = new ResLoginDTO.UserLogin();
        if (currentUserDB != null) {
            userLogin.setEmail(email);
            userLogin.setId(currentUserDB.getId());
            userLogin.setName(currentUserDB.getName());
        }
        return userLogin;
    }

}
