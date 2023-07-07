package com.b1g4.jejudongggotgilrong.entity.error;

public class NotFoundException extends ApplicationException {

    public NotFoundException(ApplicationError error) {
        super(error);
    }
}
