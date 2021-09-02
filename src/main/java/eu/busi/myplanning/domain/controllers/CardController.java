package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.CardApi;
import eu.busi.myplanning.models.CardDTO;
import eu.busi.myplanning.models.EventDTO;
import eu.busi.myplanning.models.PageCardDTO;
import eu.busi.myplanning.models.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class CardController implements CardApi {

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Void> deleteCard(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<CardDTO> findCard(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<EventDTO>> findCardContent(Long userId, String type, LocalDateTime start, LocalDateTime end) {
        return null;
    }

    @Override
    public ResponseEntity<List<CardDTO>> findCardsByUser(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<PageCardDTO> listCards(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<CardDTO> saveCard(CardDTO body) {
        return null;
    }

    @Override
    public ResponseEntity<CardDTO> updateCard(CardDTO body, Long id) {
        return null;
    }
}