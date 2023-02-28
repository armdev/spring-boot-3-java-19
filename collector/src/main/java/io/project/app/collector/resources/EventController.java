/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.app.collector.resources;

import io.project.app.collector.domain.CloudEvent;
import io.project.app.collector.services.CloudEventService;
import io.project.app.collector.services.Direction;
import java.util.List;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.HttpExchange;

/**
 *
 * @author armena
 */
@RestController
@Slf4j
@RequestMapping("/api/v2/events")
public class EventController {

    @Autowired
    private CloudEventService cloudEventService;

    @PostMapping(path = "/create")
    public ResponseEntity create(@RequestBody CloudEvent cloudEvent) {
        cloudEventService.saveEvent(cloudEvent);
        return ResponseEntity.status(HttpStatus.OK).body("Done");

    }

    @GetMapping(path = "/find/me")
    public ResponseEntity find() {
        List<CloudEvent> allList = cloudEventService.getAllList();
        return ResponseEntity.status(HttpStatus.OK).body(allList);

    }

    @GetMapping(path = "/generate")
    public ResponseEntity generateMillion() {
        CloudEvent cloudEvent = new CloudEvent();
        int nextInt = new Random().nextInt(Direction.values().length);
        cloudEvent.setEventType(Direction.values()[nextInt].name());
        cloudEvent.setEvent("Event log generated");
        cloudEventService.saveEvent(cloudEvent);
        return ResponseEntity.status(HttpStatus.OK).body("Done");

    }

    @GetMapping(path = "/show/count")
    public ResponseEntity count() {
        long count = cloudEventService.getCount();
        return ResponseEntity.status(HttpStatus.OK).body(count);

    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity delete() {
        cloudEventService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

    @HttpExchange(method = "GET", url = "/ping")//hidden from swagger
    public ResponseEntity ping() {
        return ResponseEntity.status(HttpStatus.OK).body("PING_PONG");
    }

}
