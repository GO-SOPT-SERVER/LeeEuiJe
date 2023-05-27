package org.sopt.SixthSeminar.exception.model;

import lombok.Getter;
import org.sopt.SixthSeminar.exception.Error;

@Getter
public class SoptException extends RuntimeException {

    private final Error error;

    public SoptException(Error error, String message) {
        super(message);
        this.error = error;
    }

    public int getHttpStatus() {
        return error.getHttpStatusCode();
    }
}