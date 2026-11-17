package com.mahmed1109.matchday.controller;
import com.mahmed1109.matchday.model.CreateUserDTO;
import com.mahmed1109.matchday.model.UserResponseDTO;
import com.mahmed1109.matchday.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody CreateUserDTO userDTO) {
        UserResponseDTO newUser=userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);    }
}
