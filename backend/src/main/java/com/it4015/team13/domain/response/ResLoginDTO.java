package com.it4015.team13.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResLoginDTO {
    private String accessToken;
    private UserLogin userLogin;

    @Getter
    @Setter
    public static class UserLogin {
        private long id;
        private String email;
        private String name;
    }

}
