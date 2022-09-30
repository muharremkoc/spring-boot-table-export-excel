package com.export.excel.mapper;

import com.export.excel.dto.UserRequestDto;
import com.export.excel.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {
    @Mapping(target = "username",source = "username")
    @Mapping(target = "email",source = "email")
    User userDTOtoUser(UserRequestDto userRequestDTO);
}
