package com.mahmed1109.matchday.exception;

public class FollowedTeamNotFoundException extends RuntimeException {
    public FollowedTeamNotFoundException(String userid, String teamId) {

        super("User: " + userid + " is already following team: " + teamId);
    }
}
