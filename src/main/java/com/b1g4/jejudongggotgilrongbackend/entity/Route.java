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
@AttributeOverride(name = "id", column = @Column(name = "route_id"))
@Entity
public class Route extends BaseEntity {

    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "route", cascade = CascadeType.MERGE)
    private List<BusStopRoute> busStopRoutes = new ArrayList<>();
}
