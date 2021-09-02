package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.EventApi;
import eu.busi.myplanning.models.EventDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class EventController implements EventApi {

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Void> deleteEvent(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<EventDTO> findEvent(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<EventDTO>> listEvents(Long userId, LocalDateTime startDate, LocalDateTime endDate) {
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