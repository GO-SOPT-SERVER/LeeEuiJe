package org.sopt.SeventhSeminar.exception.model;

import org.sopt.SeventhSeminar.exception.Error;

public class ConflictException extends SoptException {
    public ConflictException(Error error, String message) {
        super(error, message);
    }
}