package com.b1g4.jejudongggotgilrongbackend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(name = "id", column = @Column(name = "place_id"))
@SQLDelete(sql = "UPDATE place SET id_deleted = true WHERE place_id=?")
@Where(clause = "is_deleted = false")
@Entity
public class Place extends BaseEntity {

    private String image;
    private String name;
    private String address;
    private String description;
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_stop_id")
    private BusStop busStop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private Route route;

    public String getNearByBusStop() {
        return busStop.getName();
    }
}
