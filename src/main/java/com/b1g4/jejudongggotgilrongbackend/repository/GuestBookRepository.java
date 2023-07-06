package com.b1g4.jejudongggotgilrongbackend.repository;

import com.b1g4.jejudongggotgilrongbackend.entity.GuestBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestBookRepository extends JpaRepository<GuestBook, Long> {

    List<GuestBook> findTop5ByRouteIdOrderByCreatedDateDesc(Long routeId);

    List<GuestBook> findByRouteIdOrderByCreatedDateDesc(Long routeId);

    List<GuestBook> findByBusStopIdOrderByCreatedDateDesc(Long busStopId);
}
