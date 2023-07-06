package com.b1g4.jejudongggotgilrongbackend.controller;

import com.b1g4.jejudongggotgilrongbackend.dto.RouteDetailResponse;
import com.b1g4.jejudongggotgilrongbackend.dto.RouteResponse;
import com.b1g4.jejudongggotgilrongbackend.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    @GetMapping
    public ResponseEntity<List<RouteResponse>> getRoutes() {
        return ResponseEntity.ok(routeService.getRoutes());
    }

    @GetMapping("/{routeId}")
    public ResponseEntity<RouteDetailResponse> getRoute(@PathVariable Long routeId) {
        return ResponseEntity.ok(routeService.getRoute(routeId));
    }
}
