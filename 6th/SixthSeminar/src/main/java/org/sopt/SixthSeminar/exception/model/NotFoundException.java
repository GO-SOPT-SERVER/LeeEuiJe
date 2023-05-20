package org.sopt.SixthSeminar.exception.model;

import org.sopt.SixthSeminar.exception.Error;

public class NotFoundException extends SoptException {
    public NotFoundException(Error error, String message) {
        super(error, message);
    }
}