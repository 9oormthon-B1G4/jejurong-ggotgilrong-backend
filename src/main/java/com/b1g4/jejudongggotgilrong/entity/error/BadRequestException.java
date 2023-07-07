package com.b1g4.jejudongggotgilrong.entity.error;

public class BadRequestException extends ApplicationException {

    public BadRequestException(ApplicationError error) {
        super(error);
    }
}
