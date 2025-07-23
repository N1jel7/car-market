package com.n1jel.market.mapper;

import com.n1jel.market.dto.UserDto;
import com.n1jel.market.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserDto mapToResponse(User user);

    List<UserDto> mapToResponse(List<User> users);
}
