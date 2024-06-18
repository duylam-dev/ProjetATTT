package com.it4015.team13.util.mapper;

import com.it4015.team13.domain.User;
import com.it4015.team13.domain.response.ResCreateUserDTO;
import com.it4015.team13.domain.response.ResUserDTO;

public class UserMapper {
    public static ResCreateUserDTO toCreateUserDTO(User user) {
        var ans = new ResCreateUserDTO();
        ans.setId(user.getId());
        ans.setName(user.getName());
        ans.setEmail(user.getEmail());
        ans.setCreatedBy(user.getCreatedBy());
        ans.setCreatedAt(user.getCreatedAt());
        return ans;
    }

    public static ResUserDTO toResUserDTO(User user) {
        var ans = new ResUserDTO();
        ans.setId(user.getId());
        ans.setName(user.getName());
        ans.setEmail(user.getEmail());
        ans.setCreatedBy(user.getCreatedBy());
        ans.setCreatedAt(user.getCreatedAt());
        ans.setUpdateAt(user.getUpdatedAt());
        ans.setUpdateBy(user.getUpdatedBy());
        return ans;

    }
}
