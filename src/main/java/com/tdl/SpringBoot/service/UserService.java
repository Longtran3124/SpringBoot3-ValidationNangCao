package com.tdl.SpringBoot.service;

import com.tdl.SpringBoot.dto.request.UserCreationRequest;
import com.tdl.SpringBoot.dto.request.UserUpdateRequest;
import com.tdl.SpringBoot.dto.response.UserResponse;
import com.tdl.SpringBoot.entity.User;
import com.tdl.SpringBoot.exception.AppException;
import com.tdl.SpringBoot.exception.ErrorCode;
import com.tdl.SpringBoot.mapper.UserMapper;
import com.tdl.SpringBoot.repository.UserRepositorry;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepositorry userRepositorry;
    UserMapper userMapper;


    public User createUser(UserCreationRequest request) {

        if (userRepositorry.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);
        User user = userMapper.toUser(request);

        return userRepositorry.save(user);
    }

    public List<User> getUsers() {
        return userRepositorry.findAll();
    }

    public UserResponse getUsers(String id) {
        return userMapper.toUserResponse(userRepositorry.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found")));
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        User user = userRepositorry.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found"));
        userMapper.updateUser(user, request);

        return userMapper.toUserResponse(userRepositorry.save(user));
    }

    public void deleteUser(String userId) {
        userRepositorry.deleteById(userId);
    }
}
