package eu.busi.myplanning.domain.repositories;

import eu.busi.myplanning.domain.models.Agenda;
import eu.busi.myplanning.domain.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

/**
 * The interface Event repository.
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    /**
     * Find events of the day incoming list.
     *
     * @param agendas        the agendas
     * @param type           the type
     * @param startDate      the start date
     * @param endDatePattern the end date pattern
     * @return the list
     */
    @Query(value = "SELECT event.* FROM events as event where (event.id_agenda in (?1)) and event.event_type = ?2 and event.start_date >= ?3 AND event.end_date LIKE CONCAT('%',?4,'%') ORDER BY event.start_date ASC", nativeQuery = true)
    List<Event> findEventsOfTheDayIncoming(List<Agenda> agendas, String type, Instant startDate, String endDatePattern);

    /**
     * Find distinct by agenda is in and start date is between list.
     *
     * @param agendas the agendas
     * @param start   the start
     * @param end     the end
     * @return the list
     */
    List<Event> findDistinctByAgendaIsInAndStartDateIsBetween(
            List<Agenda> agendas,
            Instant start,
            Instant end
    );

    /**
     * Find distinct by agenda is in and end date is between list.
     *
     * @param agendas the agendas
     * @param start   the start
     * @param end     the end
     * @return the list
     */
    List<Event> findDistinctByAgendaIsInAndEndDateIsBetween(
            List<Agenda> agendas,
            Instant start,
            Instant end
    );
}