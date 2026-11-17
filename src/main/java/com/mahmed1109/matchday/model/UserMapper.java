package com.mahmed1109.matchday.model;
import com.mahmed1109.matchday.model.User;
import com.mahmed1109.matchday.model.CreateUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toDocument(CreateUserDTO createUserDTO);

    UserResponseDTO toResponse(User user);
}
