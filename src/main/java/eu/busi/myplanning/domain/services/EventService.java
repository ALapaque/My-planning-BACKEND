package eu.busi.myplanning.domain.services;

import eu.busi.myplanning.domain.enumerations.EventType;
import eu.busi.myplanning.domain.models.Event;

import java.time.Instant;
import java.util.List;

public interface EventService extends GenericService<Event, Long> {
    List<Event> findEventsByUserAndTypeAndStartAndEnd(Long id, EventType type, Instant start, Instant end);

    List<Event> findEventsByUserAndStartAndEnd(Long id, Instant startDate, Instant endDate);
}