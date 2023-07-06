package com.b1g4.jejudongggotgilrongbackend.repository;

import com.b1g4.jejudongggotgilrongbackend.entity.GuestBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GuestBookRepository extends JpaRepository<GuestBook, Long> {

//    @Query(value = "select res.bus_stop_id, name, content " +
//            "from (select name, number, bus_stop_id from route join bus_stop_route on :routeId = bus_stop_route.route_id) res, guest_book" +
//            " where guest_book.bus_stop_id = res.bus_stop_id " +
//            " order by created_date desc " +
//            "limit 5",
//            nativeQuery = true)
//    List<GuestBook> findByRouteOrderByCreatedDateDesc(@Param("routeId") Long routeId);

    List<GuestBook> findByRouteIdOrderByCreatedDateDesc(Long routeId);

    List<GuestBook> findByBusStopIdOrderByCreatedDateDesc(Long busStopId);
}
