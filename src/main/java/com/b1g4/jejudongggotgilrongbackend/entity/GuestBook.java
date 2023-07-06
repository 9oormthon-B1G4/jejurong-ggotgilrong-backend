package com.b1g4.jejudongggotgilrongbackend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(name = "id", column = @Column(name = "guest_book_id"))
@Entity
public class GuestBook extends BaseEntity {

    private String author;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bust_stop_id")
    private BusStop busStop;
}
