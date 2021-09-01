package eu.busi.myplanning.domain.controllers;

import eu.busi.myplanning.api.EventApi;
import eu.busi.myplanning.models.EventDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.threeten.bp.OffsetDateTime;

import java.time.Instant;
import java.util.List;

@RestController
public class EventController implements EventApi {

    @Override
    public ResponseEntity<Void> deleteEvent(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<EventDTO> findEvent(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<EventDTO>> listEvents(Long userId, OffsetDateTime startDate, OffsetDateTime endDate) {
        return null;
    }

    @Override
    public ResponseEntity<EventDTO> saveEvent(EventDTO body) {
        return null;
    }

    @Override
    public ResponseEntity<EventDTO> updateEvent(EventDTO body, Long id) {
        return null;
    }
}