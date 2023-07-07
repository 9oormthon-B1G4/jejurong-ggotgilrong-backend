package com.b1g4.jejudongggotgilrong.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GuestBookResponse {

    private String author;
    private String content;
    private LocalDate createdDate;
}
