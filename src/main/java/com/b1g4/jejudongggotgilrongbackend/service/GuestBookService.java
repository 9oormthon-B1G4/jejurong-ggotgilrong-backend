package com.b1g4.jejudongggotgilrongbackend.service;

import com.b1g4.jejudongggotgilrongbackend.dto.GuestBookRequest;
import com.b1g4.jejudongggotgilrongbackend.dto.GuestBookResponse;
import com.b1g4.jejudongggotgilrongbackend.entity.BusStop;
import com.b1g4.jejudongggotgilrongbackend.entity.GuestBook;
import com.b1g4.jejudongggotgilrongbackend.entity.error.ApplicationError;
import com.b1g4.jejudongggotgilrongbackend.entity.error.NotFoundException;
import com.b1g4.jejudongggotgilrongbackend.repository.BusStopRepository;
import com.b1g4.jejudongggotgilrongbackend.repository.GuestBookRepository;
import com.b1g4.jejudongggotgilrongbackend.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GuestBookService {

    private static final String AUTHOR = "익명의 사용자";

    private final GuestBookRepository guestBookRepository;
    private final BusStopRepository busStopRepository;

    @Transactional(readOnly = true)
    public List<GuestBookResponse> getGuestBooksByRoute(Long routeId) {
        return guestBookRepository.findByRouteIdOrderByCreatedDateDesc(routeId)
                .stream()
                .map(guestBook -> GuestBookResponse.builder()
                        .author(guestBook.getAuthor())
                        .content(guestBook.getContent())
                        .createdDate(guestBook.getCreatedDate().toLocalDate())
                        .build())
                .toList();
    }

    @Transactional(readOnly = true)
    public List<GuestBookResponse> getGuestBook(Long busStopId) {
        return guestBookRepository.findByBusStopIdOrderByCreatedDateDesc(busStopId)
                .stream()
                .map(guestBook -> GuestBookResponse.builder()
                        .author(guestBook.getAuthor())
                        .content(guestBook.getContent())
                        .createdDate(guestBook.getCreatedDate().toLocalDate())
                        .build())
                .toList();
    }

    @Transactional
    public void create(Long busStopId, GuestBookRequest guestBookRequest) {
        BusStop busStop = busStopRepository.findById(busStopId)
                .orElseThrow(() -> new NotFoundException(ApplicationError.ROUTE_NOT_FOUND));
        GuestBook guestBook = GuestBook.builder()
                .author(AUTHOR)
                .content(guestBookRequest.getContent())
                .busStop(busStop)
                .build();
        guestBookRepository.save(guestBook);
    }
}
