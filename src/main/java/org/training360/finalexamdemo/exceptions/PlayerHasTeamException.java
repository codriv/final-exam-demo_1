package org.training360.finalexamdemo.exceptions;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class PlayerHasTeamException extends AbstractThrowableProblem {

    public PlayerHasTeamException(String name) {
        super(
                URI.create("/locations/player-has-team"),
                "Player has team",
                Status.NOT_ACCEPTABLE,
                String.format("Player has team: %s", name));
    }
}
