package com.b1g4.jejudongggotgilrongbackend.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GuestBookRequest {

    private String content;
}
