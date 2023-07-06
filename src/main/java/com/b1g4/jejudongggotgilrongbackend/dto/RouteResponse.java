package com.b1g4.jejudongggotgilrongbackend.dto;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RouteResponse {

    private Long routeId;
    private String name;
    private String number;
    private List<BusStopResponse> busStopResponses;
}
