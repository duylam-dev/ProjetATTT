package com.it4015.team13.domain.response;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResUserDTO {
    private long id;
    private String email;
    private String name;
    private Instant createdAt;
    private String createdBy;
    private Instant updateAt;
    private String updateBy;
}
