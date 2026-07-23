package com.mahmed1109.matchday.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

public record CreateUserDTO(
@NotBlank (message = "Username can not be empty")
String userName,
@Email (message ="Must be in the correct email format")
String email,
@NotBlank(message="Please provide your first name")
String firstName,
@NotBlank(message="Please provide your first name")
String  lastName
) {

}


