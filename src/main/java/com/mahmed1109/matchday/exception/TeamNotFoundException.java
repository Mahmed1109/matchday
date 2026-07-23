package com.mahmed1109.matchday.exception;

public class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException(String teamId) {
        super("Team with id " + teamId + " not found");
    }
}
