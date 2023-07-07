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
@AttributeOverride(name = "id", column = @Column(name = "bus_stop_id"))
@SQLDelete(sql = "UPDATE bus_stop SET id_deleted = true WHERE bus_stop_id=?")
@Where(clause = "is_deleted = false")
@Entity
public class BusStop extends BaseEntity {

    private String name;
    private double latitude;
    private double longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private Route route;

    @Builder.Default
    @OneToMany(mappedBy = "busStop", cascade = CascadeType.MERGE)
    private List<GuestBook> guestBooks = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "busStop", cascade = CascadeType.MERGE)
    private List<Place> places = new ArrayList<>();

    public int getGuestBookCount() {
        return guestBooks.size();
    }
}
