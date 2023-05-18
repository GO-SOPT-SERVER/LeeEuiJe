package sopt.org.FourthSeminar.exception.model;

import sopt.org.FourthSeminar.exception.Error;

public class ConflictException extends SoptException {
    public ConflictException(Error error, String message) {
        super(error, message);
    }
}