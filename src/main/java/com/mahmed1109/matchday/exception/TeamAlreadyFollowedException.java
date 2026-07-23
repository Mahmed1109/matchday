package com.mahmed1109.matchday.exception;

public class TeamAlreadyFollowedException extends RuntimeException {
    public TeamAlreadyFollowedException(String userid, String teamid) {

        super("User: " + userid + " is already following team: " + teamid);
    }
}
