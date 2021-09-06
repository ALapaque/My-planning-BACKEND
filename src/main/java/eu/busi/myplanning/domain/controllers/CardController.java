package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.domain.api.CardApi;
import eu.busi.myplanning.domain.dto.*;
import eu.busi.myplanning.domain.services.impl.CardServiceImpl;
import eu.busi.myplanning.domain.services.impl.EventServiceImpl;
import eu.busi.myplanning.exceptions.NotDeletedException;
import eu.busi.myplanning.exceptions.NotFoundException;
import eu.busi.myplanning.exceptions.NotSavedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class CardController implements CardApi {
    private final CardServiceImpl cardService;
    private final EventServiceImpl eventService;

    public CardController(CardServiceImpl cardService, EventServiceImpl eventService) {
        this.cardService = cardService;
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
    public ResponseEntity<Boolean> deleteCard(Long id) {
        try {
            return new ResponseEntity<>(this.cardService.deleteById(id), HttpStatus.OK);
        } catch (NotDeletedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> findCard(Long id) {
        try {
            Optional<CardDTO> optional = this.cardService.findById(id);

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
    public ResponseEntity<Object> findCardContent(Long userId, CardType type, Instant start, Instant end) {
        try {
            List<EventDTO> events = null;

            if (type.equals(CardType.APPOINTMENT)) {
                events = this.eventService.findEventsByUserAndTypeAndStartAndEnd(userId, EventType.APPOINTMENT, start, end);
            } else if (type.equals(CardType.MEETING)) {
                events = this.eventService.findEventsByUserAndTypeAndStartAndEnd(userId, EventType.MEETING, start, end);
            }

            if (events.isEmpty()) {
                throw new NotFoundException();
            } else {
                return new ResponseEntity<>(events, HttpStatus.OK);
            }
        } catch (NotFoundException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> findCardsByUser(Long id) {
        try {
            return new ResponseEntity<>(this.cardService.findCardsByUserId(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> listCards(Pageable pageable) {
        try {
            //PageCardDTO page = new PageCardDTO().content(this.cardService.findAll());

            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (NotFoundException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }    }

    @Override
    public ResponseEntity<Object> saveCard(CardDTO body) {
        try {
            return new ResponseEntity<>(this.cardService.save(body), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> updateCard(CardDTO body, Long id) {
        try {
            return new ResponseEntity<>(this.cardService.update(body, id), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }    }
}