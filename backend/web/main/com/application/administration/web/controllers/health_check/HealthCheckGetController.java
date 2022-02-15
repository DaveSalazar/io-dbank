package com.application.administration.web.controllers.health_check;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@CrossOrigin
public final class HealthCheckGetController {

    @GetMapping("/health-check")
    public ResponseEntity<HashMap<String, String>> handle() {
        HashMap<String, String> status = new HashMap<>();
        status.put("status", "ok");
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
