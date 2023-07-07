package com.b1g4.jejudongggotgilrong.dto;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RouteDetailResponse {

    private String description;
    private List<BusStopMapResponse> busStopMapResponses;
    private List<GuestBookPreviewResponse> guestBookPreviewResponses;
    private List<RecommendedPlaceResponse> recommendedPlaceResponses;
}
