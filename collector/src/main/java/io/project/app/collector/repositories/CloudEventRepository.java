package io.project.app.collector.repositories;

import io.project.app.collector.domain.CloudEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CloudEventRepository extends JpaRepository<CloudEvent, Long> {
 

}
