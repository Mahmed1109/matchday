package com.mahmed1109.matchday.service;
import com.mahmed1109.matchday.model.User;
import com.mahmed1109.matchday.model.CreateUserDTO;
import com.mahmed1109.matchday.model.UserMapper;
import com.mahmed1109.matchday.model.UserResponseDTO;
import org.springframework.stereotype.Service;
import com.mahmed1109.matchday.repository.UserRepository;
import com.mahmed1109.matchday.exception.UserNotFoundException;
import com.mahmed1109.matchday.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName)
                .orElseThrow(() -> new UserNotFoundException(userName));

    }

    public UserResponseDTO createUser(CreateUserDTO createUserDTO) {
        Optional<User> existingUser = userRepository.findByUserName(createUserDTO.userName());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException(createUserDTO.userName());
        }
        User user = userMapper.toDocument(createUserDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    public User findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

}

