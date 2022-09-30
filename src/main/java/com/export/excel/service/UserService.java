package com.export.excel.service;

import com.export.excel.dto.UserRequestDto;
import com.export.excel.enums.SocialMedia;
import com.export.excel.model.User;

import java.util.List;

public interface UserService {

    User saveUser(UserRequestDto userRequestDTO, SocialMedia socialMedia);

    User updateUser(String id, UserRequestDto userRequestDTO,SocialMedia socialMedia);


    void deleteUser(String id);


    List<User> getUsers();

}
