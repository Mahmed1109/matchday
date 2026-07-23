package com.mahmed1109.matchday.exception;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String userName) {
        super("User with name " + userName + " already exists please log into that account");
    }
}
