package org.sopt.SeventhSeminar.exception.model;

import org.sopt.SeventhSeminar.exception.Error;

public class BadRequestException extends SoptException {
    public BadRequestException(Error error, String message) {
        super(error, message);
    }
}
