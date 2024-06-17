package com.it4015.team13.domain.response.User;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResUpdateUserDTO {
    private long id;
    private String email;
    private String name;
    private Instant updateAt;
    private String updateBy;

}
