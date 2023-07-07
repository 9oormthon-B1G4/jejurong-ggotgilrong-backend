package com.b1g4.jejudongggotgilrong.controller;

import com.b1g4.jejudongggotgilrong.ImageUtil;
import com.b1g4.jejudongggotgilrong.dto.RouteDetailResponse;
import com.b1g4.jejudongggotgilrong.dto.RouteResponse;
import com.b1g4.jejudongggotgilrong.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/image")
    public ResponseEntity<Void> saveImage(@RequestPart("file") MultipartFile multipartFile) {
        ImageUtil.saveImage(multipartFile);
        return ResponseEntity.ok().build();
    }
}
