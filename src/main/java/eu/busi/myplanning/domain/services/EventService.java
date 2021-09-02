package eu.busi.myplanning.domain.services;

import eu.busi.myplanning.exceptions.NotFoundException;
import eu.busi.myplanning.models.EventDTO;
import eu.busi.myplanning.models.EventType;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService extends GenericService<EventDTO, Long> {
    List<EventDTO> findEventsByUserAndTypeAndStartAndEnd(Long id, EventType type, LocalDateTime start, LocalDateTime end) throws NotFoundException;

    List<EventDTO> findEventsByUserAndStartAndEnd(Long id, LocalDateTime startDate, LocalDateTime endDate) throws NotFoundException;
}