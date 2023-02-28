/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.app.collector.services;

import io.project.app.collector.domain.CloudEvent;
import io.project.app.collector.repositories.CloudEventRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author armena
 */
@Service
@Slf4j
public class CloudEventService {

    private final CloudEventRepository cloudEventRepository;

    @Autowired
    public CloudEventService(CloudEventRepository cloudEventRepository) {
        this.cloudEventRepository = cloudEventRepository;
    }

    public void saveEvent(CloudEvent cloudEvent) {
       /// cloudEvent.setId(System.currentTimeMillis());
        cloudEventRepository.save(cloudEvent);
    }

    public List<CloudEvent> getAllList() {
        return cloudEventRepository.findAll();
    }

}
