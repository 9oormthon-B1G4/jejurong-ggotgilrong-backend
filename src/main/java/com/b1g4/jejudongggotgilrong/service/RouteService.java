package com.b1g4.jejudongggotgilrong.service;

import com.b1g4.jejudongggotgilrong.dto.*;
import com.b1g4.jejudongggotgilrong.entity.Route;
import com.b1g4.jejudongggotgilrong.entity.error.ApplicationError;
import com.b1g4.jejudongggotgilrong.entity.error.NotFoundException;
import com.b1g4.jejudongggotgilrong.repository.GuestBookRepository;
import com.b1g4.jejudongggotgilrong.repository.PlaceRepository;
import com.b1g4.jejudongggotgilrong.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final GuestBookRepository guestBookRepository;
    private final PlaceRepository placeRepository;

    @Transactional(readOnly = true)
    public List<RouteResponse> getRoutes() {
        return routeRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"))
                .stream()
                .map(route -> RouteResponse.builder()
                        .routeId(route.getId())
                        .name(route.getName())
                        .number(route.getNumber())
                        .busStopResponses(route.getBusStops()
                                .stream()
                                .map(busStop -> BusStopResponse.builder()
                                        .busStopId(busStop.getId())
                                        .name(busStop.getName())
                                        .build())
                                .toList())
                        .build())
                .toList();
    }

    @Transactional(readOnly = true)
    public RouteDetailResponse getRoute(Long routeId) {
        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new NotFoundException(ApplicationError.ROUTE_NOT_FOUND));
        return RouteDetailResponse.builder()
                .description(route.getDescription())
                .busStopMapResponses(route.getBusStops()
                        .stream()
                        .map(busStop -> BusStopMapResponse.builder()
                                .name(busStop.getName())
                                .latitude(busStop.getLatitude())
                                .longitude(busStop.getLongitude())
                                .guestBookCount(busStop.getGuestBookCount())
                                .build())
                        .toList())
                .guestBookPreviewResponses(guestBookRepository.findTop5ByRouteIdOrderByCreatedDateDesc(routeId)
                        .stream()
                        .map(guestBook -> GuestBookPreviewResponse.builder()
                                .busStopId(guestBook.getBusStop().getId())
                                .busStopName(guestBook.getBusStop().getName())
                                .content(guestBook.getContent())
                                .build())
                        .toList())
                .recommendedPlaceResponses(placeRepository.findByRouteId(routeId)
                        .stream()
                        .map(place -> RecommendedPlaceResponse.builder()
                                .image(place.getImage())
                                .name(place.getName())
                                .busStopName(place.getNearByBusStop())
                                .description(place.getDescription())
                                .url(place.getUrl())
                                .build())
                        .toList()
                )
                .build();
    }
}
