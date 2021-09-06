package eu.busi.myplanning.domain.services;

import eu.busi.myplanning.api.models.EventDTO;
import eu.busi.myplanning.api.models.EventType;
import eu.busi.myplanning.exceptions.NotFoundException;

import java.time.Instant;
import java.util.List;

public interface EventService extends GenericService<EventDTO, Long> {
    List<EventDTO> findEventsByUserAndTypeAndStartAndEnd(Long id, EventType type, Instant start, Instant end) throws NotFoundException;

    List<EventDTO> findEventsByUserAndStartAndEnd(Long id, Instant startDate, Instant endDate) throws NotFoundException;
}