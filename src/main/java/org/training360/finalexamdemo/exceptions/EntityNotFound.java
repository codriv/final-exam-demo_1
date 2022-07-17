package org.training360.finalexamdemo.exceptions;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class EntityNotFound extends AbstractThrowableProblem {

    public EntityNotFound(String entity, long id) {
        super(
                URI.create("/locations/entity-not-found"),
                "Not found",
                Status.NOT_FOUND,
                String.format("%s not found with id: %d", entity, id));
    }
}