package eu.busi.myplanning.domain.controllers;

import eu.busi.myplanning.api.CardApi;
import eu.busi.myplanning.domain.enumerations.CardType;
import eu.busi.myplanning.domain.mappers.CardMapper;
import eu.busi.myplanning.domain.models.Card;
import eu.busi.myplanning.models.CardDTO;
import eu.busi.myplanning.models.EventDTO;
import eu.busi.myplanning.models.PageCardDTO;
import eu.busi.myplanning.models.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.threeten.bp.OffsetDateTime;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CardController implements CardApi {


    @Override
    public ResponseEntity<CardDTO> aveCard(CardDTO body) {
        return null;
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
    public ResponseEntity<List<EventDTO>> findCardContent(Long userId, String type, OffsetDateTime start, OffsetDateTime end) {
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
    public ResponseEntity<CardDTO> updateCard(CardDTO body, Long id) {
        return null;
    }
}