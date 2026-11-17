package com.mahmed1109.matchday.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String userName) {
        super("Can not find user with username: " + userName);
    }}
