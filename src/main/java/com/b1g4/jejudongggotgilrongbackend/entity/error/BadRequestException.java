package com.b1g4.jejudongggotgilrongbackend.entity.error;

public class BadRequestException extends ApplicationException {

    public BadRequestException(ApplicationError error) {
        super(error);
    }
}
