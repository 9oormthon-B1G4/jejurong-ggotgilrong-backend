package com.b1g4.jejudongggotgilrong.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GuestBookPreviewResponse {

    private Long busStopId;
    private String busStopName;
    private String content;
}
