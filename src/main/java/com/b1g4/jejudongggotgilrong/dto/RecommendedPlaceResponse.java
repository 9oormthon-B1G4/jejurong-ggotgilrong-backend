package com.b1g4.jejudongggotgilrong.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecommendedPlaceResponse {

    private String image;
    private String name;
    private String description;
    private String busStopName;
    private String url;
}
