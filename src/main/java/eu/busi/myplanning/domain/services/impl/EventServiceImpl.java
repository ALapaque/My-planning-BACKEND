package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.domain.enumerations.EventType;
import eu.busi.myplanning.domain.models.Agenda;
import eu.busi.myplanning.domain.models.Event;
import eu.busi.myplanning.domain.models.UserEntity;
import eu.busi.myplanning.domain.repositories.AgendaRepository;
import eu.busi.myplanning.domain.repositories.EventRepository;
import eu.busi.myplanning.domain.repositories.UserRepository;
import eu.busi.myplanning.domain.services.EventService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class EventServiceImpl implements EventService {
    private final EventRepository repository;
    private final AgendaRepository agendaRepository;
    private final UserRepository userRepository;

    private ZoneId zoneId = ZoneId.of("Europe/Brussels");

    public EventServiceImpl(EventRepository repository, AgendaRepository agendaRepository, UserRepository userRepository) {
        this.repository = repository;
        this.agendaRepository = agendaRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Event save(Event entity) {
        return repository.save(entity);
    }

    @Override
    public List<Event> save(List<Event> entities) {
        return (List<Event>) repository.saveAll(entities);
    }

    @Override
    public boolean deleteById(Long id) {
        repository.deleteById(id);

        return !repository.existsById(id);
    }

    @Override
    public Event findById(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Event> findAll() {
        return (List<Event>) repository.findAll();
    }

    @Override
    public Page<Event> findAll(Pageable pageable) {
        Page<Event> entityPage = repository.findAll(pageable);
        List<Event> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Event update(Event entity, Long id) {
        Event event = findById(id);

        event.setName(entity.getName());
        event.setADayOff(entity.isADayOff());
        event.setPrivate(entity.isPrivate());
        event.setStatusDisplayed(entity.getStatusDisplayed());
        event.setEventType(entity.getEventType());
        event.setStartDate(entity.getStartDate());
        event.setEndDate(entity.getEndDate());
        event.setMeetingUrl(entity.getMeetingUrl());
        event.setReport(entity.getReport());
        event.setComments(entity.getComments());
        event.setAgenda(entity.getAgenda());
        event.setSharedAgendas(entity.getSharedAgendas());
        return repository.save(event);
    }

    @Override
    public List<Event> findEventsByUserAndTypeAndStartAndEnd(Long id, EventType type, Instant start, Instant end) {
        UserEntity user = userRepository.getById(id);
        List<Agenda> agendas = agendaRepository.findAgendaByUser(user);

        return repository.findEventsOfTheDayIncoming(
                agendas,
                type.toString(),
                start,
                LocalDateTime.ofInstant(end, this.zoneId).format(DateTimeFormatter.ISO_LOCAL_DATE)
        );
    }

    @Override
    public List<Event> findEventsByUserAndStartAndEnd(Long id, Instant startDate, Instant endDate) {
        UserEntity user = userRepository.getById(id);
        List<Agenda> agendas = agendaRepository.findAgendaByUser(user);

        return repository.findDistinctByAgendaInAndStartDateIsBetweenOrEndDateIsBetween(agendas, startDate, endDate, startDate, endDate);
    }
}