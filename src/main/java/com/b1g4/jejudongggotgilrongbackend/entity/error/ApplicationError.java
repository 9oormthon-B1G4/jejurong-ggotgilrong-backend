package com.b1g4.jejudongggotgilrongbackend.entity.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ApplicationError {

    ROUTE_NOT_FOUND(HttpStatus.BAD_REQUEST, "R001", "노선을 찾을 수 없습니다."),

    BUS_STOP_NOT_FOUND(HttpStatus.BAD_REQUEST, "B001", "정류장을 찾을 수 없습니다."),

    PLACE_NOT_FOUND(HttpStatus.BAD_REQUEST, "P001", "장소를 찾을 수 없습니다."),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "S001", "서버 내부 에러가 발생했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
