package com.tdl.SpringBoot.mapper;

import com.tdl.SpringBoot.dto.request.UserCreationRequest;
import com.tdl.SpringBoot.dto.request.UserUpdateRequest;
import com.tdl.SpringBoot.dto.response.UserResponse;
import com.tdl.SpringBoot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);

}
