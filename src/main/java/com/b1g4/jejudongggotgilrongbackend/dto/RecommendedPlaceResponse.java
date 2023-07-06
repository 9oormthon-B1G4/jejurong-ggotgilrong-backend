package com.b1g4.jejudongggotgilrongbackend.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecommendedPlaceResponse {

    private String image;
    private String name;
    private String address;
    private String description;
    private String url;
}
