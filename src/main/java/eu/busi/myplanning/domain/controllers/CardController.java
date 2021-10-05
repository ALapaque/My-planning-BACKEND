package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.controllers.CardApi;
import eu.busi.myplanning.api.models.*;
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
import java.util.List;
import java.util.Optional;

/**
 * Card controller
 * This contains all the endpoints
 */
@RestController
public class CardController implements CardApi {
    private final CardServiceImpl cardService;
    private final EventServiceImpl eventService;

    /**
     * Instantiates a new Card controller.
     *
     * @param cardService  the card service
     * @param eventService the event service
     */
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

    /**
     * this will delete a card by an id
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Boolean> deleteCard(Long id) {
        try {
            return new ResponseEntity<>(this.cardService.deleteById(id), HttpStatus.OK);
        } catch (NotDeletedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * this will find a card by an id
     * @param id
     * @return
     */
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

    /**
     * this will find the content to display of a defined card
     * @param userId
     * @param type
     * @param start
     * @param end
     * @return
     */
    @Override
    public ResponseEntity<Object> findCardContent(Long userId, CardType type, Instant start, Instant end) {
        try {
            List<EventDTO> events = null;

            if (type.equals(CardType.APPOINTMENT)) {
                events = this.eventService.findEventsByUserAndTypeAndStartAndEnd(userId, EventType.APPOINTMENT, start, end);
            } else if (type.equals(CardType.MEETING)) {
                events = this.eventService.findEventsByUserAndTypeAndStartAndEnd(userId, EventType.MEETING, start, end);
            }

            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (NotFoundException e) {
            log.error(e.toString());
            return e.responseEntity();
        }
    }

    /**
     * this will find the card used by a user
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Object> findCardsByUser(Long id) {
        try {
            return new ResponseEntity<>(this.cardService.findCardsByUserId(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            log.error(e.toString());
            return e.responseEntity();
        }
    }

    /**
     * this will return a pageable of cards
     * @param pageable
     * @return
     */
    @Override
    public ResponseEntity<Object> listCards(Pageable pageable) {
        try {
            //PageCardDTO page = new PageCardDTO().content(this.cardService.findAll());

            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (NotFoundException e) {
            log.error(e.toString());
            return e.responseEntity();
        }
    }

    /**
     * this will save a card
     * @param body
     * @return
     */
    @Override
    public ResponseEntity<Object> saveCard(CardDTO body) {
        try {
            return new ResponseEntity<>(this.cardService.save(body), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            log.error(e.toString());
            return e.responseEntity();
        }
    }

    /**
     * this will update a card
     * @param body
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Object> updateCard(CardDTO body, Long id) {
        try {
            return new ResponseEntity<>(this.cardService.update(body, id), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            log.error(e.toString());
            return e.responseEntity();
        }
    }
}