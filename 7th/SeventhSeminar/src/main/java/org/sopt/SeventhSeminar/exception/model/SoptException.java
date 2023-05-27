package org.sopt.SeventhSeminar.exception.model;

import lombok.Getter;
import org.sopt.SeventhSeminar.exception.Error;

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