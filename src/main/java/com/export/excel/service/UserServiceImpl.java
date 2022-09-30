package com.export.excel.service;

import com.export.excel.dto.UserRequestDto;
import com.export.excel.enums.SocialMedia;
import com.export.excel.mapper.UserMapper;
import com.export.excel.model.User;
import com.export.excel.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService{
    final UserRepository userRepository;

    final UserMapper userMapper;

    @Override
    public User saveUser(UserRequestDto userRequestDTO, SocialMedia socialMedia) {
        User user=userMapper.userDTOtoUser(userRequestDTO);
        user.setPassword(Base64.getEncoder().encodeToString(userRequestDTO.getPassword().getBytes(StandardCharsets.UTF_8)));
        user.setSocialMedia(socialMedia);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String id, UserRequestDto userRequestDTO, SocialMedia socialMedia) {
        return null;
    }

    @Override
    public void deleteUser(String id) {
         userRepository.deleteById(id);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
