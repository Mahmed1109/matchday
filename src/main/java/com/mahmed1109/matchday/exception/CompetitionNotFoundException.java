package com.mahmed1109.matchday.exception;

public class CompetitionNotFoundException extends RuntimeException {
    public CompetitionNotFoundException(String id) {
        super("Competition with id " + id + " not found");
    }
}
