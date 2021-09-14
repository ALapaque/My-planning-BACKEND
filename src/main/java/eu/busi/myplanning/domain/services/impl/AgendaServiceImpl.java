package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.api.models.AgendaDTO;
import eu.busi.myplanning.domain.mappers.AgendaMapper;
import eu.busi.myplanning.domain.mappers.TeamMapper;
import eu.busi.myplanning.domain.mappers.UserMapper;
import eu.busi.myplanning.domain.models.Agenda;
import eu.busi.myplanning.domain.models.UserEntity;
import eu.busi.myplanning.domain.repositories.AgendaRepository;
import eu.busi.myplanning.domain.repositories.UserRepository;
import eu.busi.myplanning.domain.services.AgendaService;
import eu.busi.myplanning.exceptions.NotDeletedException;
import eu.busi.myplanning.exceptions.NotFoundException;
import eu.busi.myplanning.exceptions.NotSavedException;
import eu.busi.myplanning.exceptions.NotUpdatedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Agenda service.
 */
@Service
@Transactional
public class AgendaServiceImpl implements AgendaService {
    private final AgendaRepository repository;
    private final UserRepository userRepository;

    public AgendaServiceImpl(AgendaRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public AgendaDTO save(AgendaDTO entity) throws NotSavedException {
        try {
            return AgendaMapper
                    .INSTANCE
                    .asDTO(repository
                            .save(AgendaMapper
                                    .INSTANCE
                                    .fromDtoToEntity(entity)));
        } catch (Exception e) {
            throw new NotSavedException();
        }
    }

    @Override
    public List<AgendaDTO> save(List<AgendaDTO> entities) throws NotSavedException {
        try {
            List<Agenda> agendas = entities
                    .stream()
                    .map(AgendaMapper.INSTANCE::fromDtoToEntity)
                    .collect(Collectors.toList());

            return repository
                    .saveAll(agendas)
                    .stream()
                    .map(AgendaMapper.INSTANCE::asDTO)
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
    public Optional<AgendaDTO> findById(Long id) throws NotFoundException {
        try {
            return repository
                    .findById(id)
                    .map(AgendaMapper.INSTANCE::asDTO);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @Override
    public List<AgendaDTO> findAll() throws NotFoundException {
        try {
            return repository
                    .findAll()
                    .stream()
                    .map(AgendaMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @Override
    public Page<AgendaDTO> findAll(Pageable pageable) throws NotFoundException {
        try {
            Page<Agenda> entityPage = repository.findAll(pageable);
            List<AgendaDTO> entities = entityPage
                    .getContent()
                    .stream()
                    .map(AgendaMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());

            return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @Override
    public AgendaDTO update(AgendaDTO entity, Long id) throws NotUpdatedException {
        try {
            Optional<AgendaDTO> optional = findById(id);

            if (optional.isPresent()) {
                Agenda agenda = AgendaMapper.INSTANCE.fromDtoToEntity(optional.get());

                agenda.setName(entity.getName());
                agenda.setColor(entity.getColor());
                agenda.setSharedUsers(entity
                        .getSharedUsers()
                        .stream()
                        .map(UserMapper.INSTANCE::fromLightDtoToEntity)
                        .collect(Collectors.toList())
                );
                agenda.setTeam(TeamMapper.INSTANCE.fromLightDtoToEntity(entity.getTeam()));
                agenda.setSharedUsers(entity
                        .getSharedUsers()
                        .stream()
                        .map(UserMapper.INSTANCE::fromLightDtoToEntity)
                        .collect(Collectors.toList())
                );
                agenda.setSharedTeams(entity
                        .getSharedTeams()
                        .stream()
                        .map(TeamMapper.INSTANCE::fromLightDtoToEntity)
                        .collect(Collectors.toList())
                );

                return save(AgendaMapper.INSTANCE.asDTO(agenda));
            } else {
                throw new Exception("Ressource not found...");
            }
        } catch (Exception e) {
            throw new NotUpdatedException();
        }
    }

    @Override
    public List<AgendaDTO> findByUser(Long id) throws NotFoundException {
        try {
            Optional<UserEntity> optional = userRepository.findById(id);

            return optional
                    .map(userEntity -> repository
                            .findDistinctByUserOrTeamIsInOrderByByDefaultDescNameAsc(userEntity, userEntity.getTeams())
                            .stream()
                            .map(AgendaMapper.INSTANCE::asDTO)
                            .collect(Collectors.toList()))
                    .orElse(null);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @Override
    public List<AgendaDTO> findSharedAgendasByUser(Long id) throws NotFoundException {
        try {
            Optional<UserEntity> optional = userRepository.findById(id);

            return optional
                    .map(userEntity -> repository
                            .findDistinctBySharedUsersIsInOrSharedTeamsIsInOrderByNameAsc(List.of(userEntity), userEntity.getTeams())
                            .stream()
                            .map(AgendaMapper.INSTANCE::asDTO)
                            .collect(Collectors.toList()))
                    .orElse(null);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
}