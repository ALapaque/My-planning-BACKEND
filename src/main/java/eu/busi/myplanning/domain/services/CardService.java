package eu.busi.myplanning.domain.services;

import eu.busi.myplanning.domain.models.Card;

import java.util.List;

public interface CardService extends GenericService<Card, Long> {
    List<Card> findCardsByUserId(Long userId);
}