package com.b1g4.jejudongggotgilrongbackend.controller;

import com.b1g4.jejudongggotgilrongbackend.dto.GuestBookRequest;
import com.b1g4.jejudongggotgilrongbackend.dto.GuestBookResponse;
import com.b1g4.jejudongggotgilrongbackend.service.GuestBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/guest-books")
public class GuestBookController {

    private final GuestBookService guestBookService;

    @GetMapping("/routes/{routeId}")
    public ResponseEntity<List<GuestBookResponse>> getGuestBooks(@PathVariable Long routeId) {
        return ResponseEntity.ok(guestBookService.getGuestBooksByRoute(routeId));
    }

    @GetMapping("/bus-stops/{busStopId}")
    public ResponseEntity<List<GuestBookResponse>> getGuestBook(@PathVariable Long busStopId) {
        return ResponseEntity.ok(guestBookService.getGuestBook(busStopId));
    }

    @PostMapping("/bus-stops/{busStopId}")
    public ResponseEntity<Void> create(@PathVariable Long busStopId, @RequestBody GuestBookRequest guestBookRequest) {
        guestBookService.create(busStopId, guestBookRequest);
        return ResponseEntity.ok().build();
    }
}
