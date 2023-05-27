package org.sopt.SeventhSeminar.exception.model;

import org.sopt.SeventhSeminar.exception.Error;

public class NotFoundException extends SoptException {
    public NotFoundException(Error error, String message) {
        super(error, message);
    }
}