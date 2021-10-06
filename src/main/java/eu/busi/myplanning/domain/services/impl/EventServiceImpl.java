package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.api.models.EventDTO;
import eu.busi.myplanning.api.models.EventType;
import eu.busi.myplanning.domain.mappers.AgendaMapper;
import eu.busi.myplanning.domain.mappers.CommentMapper;
import eu.busi.myplanning.domain.mappers.EventMapper;
import eu.busi.myplanning.domain.models.Agenda;
import eu.busi.myplanning.domain.models.Event;
import eu.busi.myplanning.domain.models.UserEntity;
import eu.busi.myplanning.domain.repositories.AgendaRepository;
import eu.busi.myplanning.domain.repositories.EventRepository;
import eu.busi.myplanning.domain.repositories.UserRepository;
import eu.busi.myplanning.domain.services.EventService;
import eu.busi.myplanning.exceptions.NotDeletedException;
import eu.busi.myplanning.exceptions.NotFoundException;
import eu.busi.myplanning.exceptions.NotSavedException;
import eu.busi.myplanning.exceptions.NotUpdatedException;
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
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type Event service.
 */
@Service
@Transactional
public class EventServiceImpl implements EventService {
    private final EventRepository repository;
    private final AgendaRepository agendaRepository;
    private final UserRepository userRepository;

    /**
     * initialize the default zoneId used by the application
     */
    private ZoneId zoneId = ZoneId.of("Europe/Brussels");

    /**
     * Instantiates a new Event service.
     *
     * @param repository       the repository
     * @param agendaRepository the agenda repository
     * @param userRepository   the user repository
     */
    public EventServiceImpl(EventRepository repository, AgendaRepository agendaRepository, UserRepository userRepository) {
        this.repository = repository;
        this.agendaRepository = agendaRepository;
        this.userRepository = userRepository;
    }

    /**
     * save an event
     * @param entity the entity
     * @return
     * @throws NotSavedException
     */
    @Override
    public EventDTO save(EventDTO entity) throws NotSavedException {
        try {
            return EventMapper
                    .INSTANCE
                    .asDTO(repository
                            .save(EventMapper
                                    .INSTANCE
                                    .fromDtoToEntity(entity)));
        } catch (Exception e) {
            throw new NotSavedException();
        }
    }

    /**
     * save a list of events
     * @param entities the entities
     * @return
     * @throws NotSavedException
     */
    @Override
    public List<EventDTO> save(List<EventDTO> entities) throws NotSavedException {
        try {
            List<Event> events = entities
                    .stream()
                    .map(EventMapper.INSTANCE::fromDtoToEntity)
                    .collect(Collectors.toList());

            return repository
                    .saveAll(events)
                    .stream()
                    .map(EventMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NotSavedException();
        }
    }

    /**
     * delete an event by an id
     * @param id the id
     * @return
     * @throws NotDeletedException
     */
    @Override
    public boolean deleteById(Long id) throws NotDeletedException {
        try {
            repository.deleteById(id);

            return !repository.existsById(id);
        } catch (Exception e) {
            throw new NotDeletedException();
        }
    }

    /**
     * find an event by an id
     * @param id the id
     * @return
     * @throws NotFoundException
     */
    @Override
    public Optional<EventDTO> findById(Long id) throws NotFoundException {
        try {
            return repository
                    .findById(id)
                    .map(EventMapper.INSTANCE::asDTO);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    /**
     * find all events
     * @return
     * @throws NotFoundException
     */
    @Override
    public List<EventDTO> findAll() throws NotFoundException {
        try {
            return repository
                    .findAll()
                    .stream()
                    .map(EventMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    /**
     * find all events from a pageable object
     * @param pageable the pageable
     * @return
     * @throws NotFoundException
     */
    @Override
    public Page<EventDTO> findAll(Pageable pageable) throws NotFoundException {
        try {
            Page<Event> entityPage = repository.findAll(pageable);
            List<EventDTO> entities = entityPage
                    .getContent()
                    .stream()
                    .map(EventMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());

            return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    /**
     * update and event
     * @param entity the entity
     * @param id     the id
     * @return
     * @throws NotUpdatedException
     */
    @Override
    public EventDTO update(EventDTO entity, Long id) throws NotUpdatedException {
        try {
            Optional<EventDTO> optional = findById(id);

            if (optional.isPresent()) {
                Event event = EventMapper.INSTANCE.fromDtoToEntity(optional.get());

                event.setName(entity.getName());
                event.setDayOff(entity.isDayOff());
                event.setPrivateEvent(entity.isPrivateEvent());
                event.setStatusDisplayed(entity.getStatusDisplayed());
                event.setEventType(entity.getEventType());
                event.setStartDate(entity.getStartDate());
                event.setEndDate(entity.getEndDate());
                event.setMeetingUrl(entity.getMeetingUrl());
                event.setReport(entity.getReport());
                event.setAgenda(AgendaMapper.INSTANCE.fromDtoToEntity(entity.getAgenda()));
                if (!entity.getComments().isEmpty()) {
                    event.setComments(entity
                            .getComments()
                            .stream()
                            .map(CommentMapper.INSTANCE::fromDtoToEntity)
                            .collect(Collectors.toList()));
                }

                if (!entity.getSharedAgendas().isEmpty()) {
                    event.setSharedAgendas(entity
                            .getSharedAgendas()
                            .stream()
                            .map(AgendaMapper.INSTANCE::fromLightDtoToEntity)
                            .collect(Collectors.toList()));
                }

                return save(EventMapper.INSTANCE.asDTO(repository.save(event)));

            } else {
                throw new Exception("Ressource not found...");
            }
        } catch (Exception e) {
            throw new NotUpdatedException();
        }
    }

    /**
     * will return event from a given type and between a start and end date
     * @param id    the id
     * @param type  the type
     * @param start the start
     * @param end   the end
     * @return
     * @throws NotFoundException
     */
    @Override
    public List<EventDTO> findEventsByUserAndTypeAndStartAndEnd(Long id, EventType type, Instant start, Instant end) throws NotFoundException {
        try {
            Optional<UserEntity> optional = userRepository.findById(id);

            if (optional.isPresent()) {
                List<Agenda> agendas = agendaRepository.findDistinctByUserOrTeamIsInOrderByByDefaultDescNameAsc(optional.get(), optional.get().getTeams());

                return repository
                        .findEventsOfTheDayIncoming(
                                agendas,
                                type.toString(),
                                start,
                                LocalDateTime.ofInstant(end, this.zoneId).format(DateTimeFormatter.ISO_LOCAL_DATE))
                        .stream()
                        .map(EventMapper.INSTANCE::asDTO)
                        .collect(Collectors.toList());
            } else {
                throw new Exception("Ressource not found...");
            }
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    /**
     * will find events which are
     * @param agendaIds the agenda ids
     * @param startDate the start date
     * @param endDate   the end date
     * @return
     * @throws NotFoundException
     */
    @Override
    public List<EventDTO> findEventsByAgendasAndStartAndEnd(List<Long> agendaIds, Instant startDate, Instant endDate) throws NotFoundException {
        try {
            List<Agenda> agendas = agendaRepository.findAllById(agendaIds);

            // this will find events of an agendas comparing the startDate
            List<Event> eventsBetweenStartDate = repository.findDistinctByAgendaIsInAndStartDateIsBetween(
                    agendas,
                    startDate,
                    endDate
            );

            // this will find events of an agendas comparing the endDate
            List<Event> eventsBetweenEndDate = repository.findDistinctByAgendaIsInAndEndDateIsBetween(
                    agendas,
                    startDate,
                    endDate
            );

            return Stream.concat(eventsBetweenStartDate.stream(), eventsBetweenEndDate.stream())
                    .distinct()
                    .map(EventMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
}