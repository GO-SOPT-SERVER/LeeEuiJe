package sopt.org.FourthSeminar.exception.model;

import sopt.org.FourthSeminar.exception.Error;

public class NotFoundException extends SoptException {
    public NotFoundException(Error error, String message) {
        super(error, message);
    }
}