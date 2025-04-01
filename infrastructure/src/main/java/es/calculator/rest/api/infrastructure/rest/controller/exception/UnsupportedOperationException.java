package es.calculator.rest.api.infrastructure.rest.controller.exception;

import java.io.Serial;

public class UnsupportedOperationException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 8579183317692218382L;

    public UnsupportedOperationException(String message) {
        super(message);
    }
}