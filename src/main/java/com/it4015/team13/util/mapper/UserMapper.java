package com.it4015.team13.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.it4015.team13.domain.User;
import com.it4015.team13.domain.response.User.ResCreateUserDTO;
import com.it4015.team13.domain.response.User.ResUpdateUserDTO;
import com.it4015.team13.domain.response.User.ResUserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
    ResCreateUserDTO toResCreateDTO(User user);

    ResUserDTO toResUserDTO(User user);

    void updateUser(@MappingTarget ResUpdateUserDTO updateUserDTO, User user);

}
