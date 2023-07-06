package com.b1g4.jejudongggotgilrongbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(name = "id", column = @Column(name = "bus_stop_id"))
@Entity
public class BusStop extends BaseEntity {

    private String name;
    private double latitude;
    private double longitude;

    @Builder.Default
    @OneToMany(mappedBy = "busStop", cascade = CascadeType.MERGE)
    private List<BusStopRoute> busStopRoutes = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "busStop", cascade = CascadeType.MERGE)
    private List<GuestBook> guestBooks = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "busStop", cascade = CascadeType.MERGE)
    private List<Place> places = new ArrayList<>();
}
