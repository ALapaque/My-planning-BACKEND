package eu.busi.myplanning.domain.services;

import eu.busi.myplanning.domain.dto.CardDTO;
import eu.busi.myplanning.exceptions.NotFoundException;
import java.util.List;

public interface CardService extends GenericService<CardDTO, Long> {
    List<CardDTO> findCardsByUserId(Long userId) throws NotFoundException;
}