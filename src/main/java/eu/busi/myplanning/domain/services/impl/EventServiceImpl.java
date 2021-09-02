package eu.busi.myplanning.domain.services.impl;

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
import eu.busi.myplanning.models.EventDTO;
import eu.busi.myplanning.models.EventType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public boolean deleteById(Long id) throws NotDeletedException {
        try {
            repository.deleteById(id);

            return !repository.existsById(id);
        } catch (Exception e) {
            throw new NotDeletedException();
        }
    }

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

    @Override
    public EventDTO update(EventDTO entity, Long id) throws NotUpdatedException {
        try {
            Optional<EventDTO> optional = findById(id);

            if (optional.isPresent()) {
                Event event = EventMapper.INSTANCE.fromDtoToEntity(optional.get());

                event.setName(entity.getName());
                event.setADayOff(entity.isAdayOff());
                event.setPrivate(entity.isPrivate());
                event.setStatusDisplayed(entity.getStatusDisplayed());
                event.setEventType(entity.getEventType());
                event.setStartDate(entity.getStartDate());
                event.setEndDate(entity.getEndDate());
                event.setMeetingUrl(entity.getMeetingUrl());
                event.setReport(entity.getReport());
                event.setComments(entity
                        .getComments()
                        .stream()
                        .map(CommentMapper.INSTANCE::fromDtoToEntity)
                        .collect(Collectors.toList()));
                event.setAgenda(AgendaMapper.INSTANCE.fromDtoToEntity(entity.getAgenda()));
                event.setSharedAgendas(entity
                        .getSharedAgendas()
                        .stream()
                        .map(AgendaMapper.INSTANCE::fromLightDtoToEntity)
                        .collect(Collectors.toList()));

                return save(EventMapper.INSTANCE.asDTO(repository.save(event)));

            } else {
                throw new Exception("Ressource not found...");
            }
        } catch (Exception e) {
            throw new NotUpdatedException();
        }
    }

    @Override
    public List<EventDTO> findEventsByUserAndTypeAndStartAndEnd(Long id, EventType type, LocalDateTime start, LocalDateTime end) throws NotFoundException {
        try {
            Optional<UserEntity> optional = userRepository.findById(id);

            if (optional.isPresent()) {
                List<Agenda> agendas = agendaRepository.findAgendaByUser(optional.get());

                return repository
                        .findEventsOfTheDayIncoming(
                                agendas,
                                type.toString(),
                                start,
                                end.format(DateTimeFormatter.ISO_LOCAL_DATE))
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

    @Override
    public List<EventDTO> findEventsByUserAndStartAndEnd(Long id, LocalDateTime startDate, LocalDateTime endDate) throws NotFoundException {
        try {
            Optional<UserEntity> optional = userRepository.findById(id);

            if (optional.isPresent()) {
                List<Agenda> agendas = agendaRepository.findAgendaByUser(optional.get());

                return repository
                        .findDistinctByAgendaInAndStartDateIsBetweenOrEndDateIsBetween(agendas, startDate, endDate, startDate, endDate)
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
}