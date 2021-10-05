package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.controllers.EventApi;
import eu.busi.myplanning.api.models.EventDTO;
import eu.busi.myplanning.domain.services.impl.EventServiceImpl;
import eu.busi.myplanning.exceptions.NotDeletedException;
import eu.busi.myplanning.exceptions.NotFoundException;
import eu.busi.myplanning.exceptions.NotSavedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Event controller
 * this contains all the endpoint
 */
@RestController
public class EventController implements EventApi {
    private final EventServiceImpl eventService;

    /**
     * Instantiates a new Event controller.
     *
     * @param eventService the event service
     */
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

    /**
     * delete an event by an id
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Boolean> deleteEvent(Long id) {
        try {
            return new ResponseEntity<>(this.eventService.deleteById(id), HttpStatus.OK);
        } catch (NotDeletedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * find an event by an id
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Object> findEvent(Long id) {
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

    /**
     * return all the events from different parameters
     *
     * @param userId
     * @param agendaIds
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public ResponseEntity<Object> listEvents(
            Long userId,
            List<Long> agendaIds,
            Instant startDate,
            Instant endDate
    ) {
        try {
            return new ResponseEntity<>(this.eventService.findEventsByAgendasAndStartAndEnd(agendaIds, startDate, endDate), HttpStatus.OK);
        } catch (NotFoundException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * save an event
     * @param body
     * @return
     */
    @Override
    public ResponseEntity<Object> saveEvent(EventDTO body) {
        try {
            return new ResponseEntity<>(this.eventService.save(body), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * update an event
     * @param body
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Object> updateEvent(EventDTO body, Long id) {
        try {
            return new ResponseEntity<>(this.eventService.update(body, id), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}