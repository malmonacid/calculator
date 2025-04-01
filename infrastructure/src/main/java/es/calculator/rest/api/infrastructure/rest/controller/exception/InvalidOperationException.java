package es.calculator.rest.api.infrastructure.rest.controller.exception;

import java.io.Serial;

public class InvalidOperationException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -7093286595175538774L;

    public InvalidOperationException(String message) {
        super(message);
    }
}