package com.b1g4.jejudongggotgilrongbackend.controller;

import com.b1g4.jejudongggotgilrongbackend.dto.RouteDetailResponse;
import com.b1g4.jejudongggotgilrongbackend.dto.RouteResponse;
import com.b1g4.jejudongggotgilrongbackend.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
