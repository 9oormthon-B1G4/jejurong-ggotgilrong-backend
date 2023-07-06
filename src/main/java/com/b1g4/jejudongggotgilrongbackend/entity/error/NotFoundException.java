package com.b1g4.jejudongggotgilrongbackend.entity.error;

public class NotFoundException extends ApplicationException {

    public NotFoundException(ApplicationError error) {
        super(error);
    }
}
