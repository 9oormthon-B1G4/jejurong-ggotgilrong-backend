package com.b1g4.jejudongggotgilrongbackend.service;

import com.b1g4.jejudongggotgilrongbackend.dto.BusStopResponse;
import com.b1g4.jejudongggotgilrongbackend.dto.RouteResponse;
import com.b1g4.jejudongggotgilrongbackend.entity.BusStopRoute;
import com.b1g4.jejudongggotgilrongbackend.repository.GuestBookRepository;
import com.b1g4.jejudongggotgilrongbackend.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final GuestBookRepository guestBookRepository;

    public List<RouteResponse> getRoutes() {
        return routeRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"))
                .stream()
                .map(route -> RouteResponse.builder()
                        .routeId(route.getId())
                        .name(route.getName())
                        .number(route.getNumber())
                        .busStopResponses(route.getBusStopRoutes()
                                .stream()
                                .map(BusStopRoute::getBusStop)
                                .map(busStop -> BusStopResponse.builder()
                                        .busStopId(busStop.getId())
                                        .name(busStop.getName())
                                        .build())
                                .toList())
                        .build())
                .toList();
    }
}
