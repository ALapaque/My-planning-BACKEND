package eu.busi.myplanning.domain.services;

import eu.busi.myplanning.domain.enumerations.EventType;
import eu.busi.myplanning.exceptions.NotFoundException;
import eu.busi.myplanning.models.EventDTO;
import org.threeten.bp.OffsetDateTime;

import java.time.Instant;
import java.util.List;

public interface EventService extends GenericService<EventDTO, Long> {
    List<EventDTO> findEventsByUserAndTypeAndStartAndEnd(Long id, EventType type, OffsetDateTime start, OffsetDateTime end) throws NotFoundException;

    List<EventDTO> findEventsByUserAndStartAndEnd(Long id, OffsetDateTime startDate, OffsetDateTime endDate) throws NotFoundException;
}