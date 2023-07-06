package com.b1g4.jejudongggotgilrongbackend.repository;

import com.b1g4.jejudongggotgilrongbackend.entity.GuestBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GuestBookRepository extends JpaRepository<GuestBook, Long> {

    List<GuestBook> findByRouteIdOrderByCreatedDateDesc(Long routeId);

    List<GuestBook> findByBusStopIdOrderByCreatedDateDesc(Long busStopId);
}
