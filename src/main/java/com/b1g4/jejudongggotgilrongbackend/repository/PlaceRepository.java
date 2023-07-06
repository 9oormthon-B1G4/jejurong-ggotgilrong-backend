package com.b1g4.jejudongggotgilrongbackend.repository;

import com.b1g4.jejudongggotgilrongbackend.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    List<Place> findByRouteId(Long routeId);
}
