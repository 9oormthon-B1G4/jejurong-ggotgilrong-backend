package com.b1g4.jejudongggotgilrong.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BusStopMapResponse {

    private String name;
    private double latitude;
    private double longitude;
    private int guestBookCount;
}
