package org.training360.finalexamdemo.exceptions;

import org.training360.finalexamdemo.model.PlayerPosition;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class TooManyPlayerOnPositionException extends AbstractThrowableProblem {

    public TooManyPlayerOnPositionException(PlayerPosition playerPosition) {
        super(
                URI.create("/locations/too-many-player"),
                "Too many player",
                Status.NOT_ACCEPTABLE,
                String.format("Too many player on this position: %s", playerPosition));
    }
}
