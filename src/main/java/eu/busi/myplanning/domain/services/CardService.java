package eu.busi.myplanning.domain.services;

import eu.busi.myplanning.api.models.CardDTO;
import eu.busi.myplanning.exceptions.NotFoundException;

import java.util.List;

/**
 * The interface Card service.
 */
public interface CardService extends GenericService<CardDTO, Long> {
    /**
     * Find cards by user id list.
     *
     * @param userId the user id
     * @return the list
     * @throws NotFoundException the not found exception
     */
    List<CardDTO> findCardsByUserId(Long userId) throws NotFoundException;
}