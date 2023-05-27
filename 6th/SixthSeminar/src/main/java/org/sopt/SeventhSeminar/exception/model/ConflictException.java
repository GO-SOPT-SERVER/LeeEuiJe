package org.sopt.SixthSeminar.exception.model;

import org.sopt.SixthSeminar.exception.Error;

public class ConflictException extends SoptException {
    public ConflictException(Error error, String message) {
        super(error, message);
    }
}