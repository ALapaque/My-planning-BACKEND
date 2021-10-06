package eu.busi.myplanning.domain.services;

import eu.busi.myplanning.api.models.EventDTO;
import eu.busi.myplanning.api.models.EventType;
import eu.busi.myplanning.exceptions.NotFoundException;

import java.time.Instant;
import java.util.List;

/**
 * The interface Event service.
 */
public interface EventService extends GenericService<EventDTO, Long> {
    /**
     * Find events by user and type and start and end list.
     *
     * @param id    the id
     * @param type  the type
     * @param start the start
     * @param end   the end
     * @return the list
     * @throws NotFoundException the not found exception
     */
    List<EventDTO> findEventsByUserAndTypeAndStartAndEnd(Long id, EventType type, Instant start, Instant end) throws NotFoundException;

    /**
     * Find events by agendas and start and end list.
     *
     * @param agendaIds the agenda ids
     * @param startDate the start date
     * @param endDate   the end date
     * @return the list
     * @throws NotFoundException the not found exception
     */
    List<EventDTO> findEventsByAgendasAndStartAndEnd(List<Long> agendaIds, Instant startDate, Instant endDate) throws NotFoundException;
}