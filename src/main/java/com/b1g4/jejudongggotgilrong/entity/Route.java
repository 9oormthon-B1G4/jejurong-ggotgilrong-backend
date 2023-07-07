package com.b1g4.jejudongggotgilrong.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

@Getter
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(name = "id", column = @Column(name = "route_id"))
@SQLDelete(sql = "UPDATE route SET id_deleted = true WHERE route_id=?")
@Where(clause = "is_deleted = false")
@Entity
public class Route extends BaseEntity {

    private String name;
    private String number;
    private String description;

    @Builder.Default
    @OneToMany(mappedBy = "route", cascade = CascadeType.MERGE)
    private List<BusStop> busStops = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "route", cascade = CascadeType.MERGE)
    private List<Place> places = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "route", cascade = CascadeType.MERGE)
    private List<GuestBook> guestBooks = new ArrayList<>();
}
