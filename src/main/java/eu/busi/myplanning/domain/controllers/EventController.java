package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.EventApi;
import eu.busi.myplanning.domain.services.impl.EventServiceImpl;
import eu.busi.myplanning.exceptions.NotDeletedException;
import eu.busi.myplanning.exceptions.NotFoundException;
import eu.busi.myplanning.exceptions.NotSavedException;
import eu.busi.myplanning.models.EventDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class EventController implements EventApi {
    private final EventServiceImpl eventService;

    public EventController(EventServiceImpl eventService) {
        this.eventService = eventService;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Boolean> deleteEvent(Long id) {
        try {
            return new ResponseEntity<>(this.eventService.deleteById(id), HttpStatus.OK);
        } catch (NotDeletedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<EventDTO> findEvent(Long id) {
        try {
            Optional<EventDTO> optional = this.eventService.findById(id);

            if (optional.isPresent()) {
                return new ResponseEntity<>(optional.get(), HttpStatus.OK);
            } else {
                throw new NotFoundException();
            }
        } catch (NotFoundException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<EventDTO>> listEvents(Long userId, LocalDateTime startDate, LocalDateTime endDate) {
        try {
            return new ResponseEntity<>(this.eventService.findEventsByUserAndStartAndEnd(userId, startDate, endDate), HttpStatus.OK);
        } catch (NotFoundException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<EventDTO> saveEvent(EventDTO body) {
        try {
            return new ResponseEntity<>(this.eventService.save(body), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<EventDTO> updateEvent(EventDTO body, Long id) {
        try {
            return new ResponseEntity<>(this.eventService.update(body, id), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}