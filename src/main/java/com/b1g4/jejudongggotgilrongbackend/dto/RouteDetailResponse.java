package com.b1g4.jejudongggotgilrongbackend.dto;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RouteDetailResponse {

    private List<BusStopMapResponse> busStopMapResponses;
    private List<GuestBookPreviewResponse> guestBookPreviewResponses;
    private List<RecommendedPlaceResponse> recommendedPlaceResponses;
}
