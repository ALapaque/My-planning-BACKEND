package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.api.models.TeamDTO;
import eu.busi.myplanning.domain.mappers.AgendaMapper;
import eu.busi.myplanning.domain.mappers.TeamMapper;
import eu.busi.myplanning.domain.mappers.UserMapper;
import eu.busi.myplanning.domain.models.Team;
import eu.busi.myplanning.domain.models.UserEntity;
import eu.busi.myplanning.domain.repositories.TeamRepository;
import eu.busi.myplanning.domain.repositories.UserRepository;
import eu.busi.myplanning.domain.services.TeamService;
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

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    private final TeamRepository repository;
    private final UserRepository userRepository;

    public TeamServiceImpl(TeamRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public TeamDTO save(TeamDTO entity) throws NotSavedException {
        try {
            return TeamMapper
                    .INSTANCE
                    .asDTO(repository
                            .save(TeamMapper
                                    .INSTANCE
                                    .fromDtoToEntity(entity)));
        } catch (Exception e) {
            throw new NotSavedException();
        }
    }

    @Override
    public List<TeamDTO> save(List<TeamDTO> entities) throws NotSavedException {
        try {
            List<Team> teams = entities
                    .stream()
                    .map(TeamMapper.INSTANCE::fromDtoToEntity)
                    .collect(Collectors.toList());

            return repository
                    .saveAll(teams)
                    .stream()
                    .map(TeamMapper.INSTANCE::asDTO)
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
    public Optional<TeamDTO> findById(Long id) throws NotFoundException {
        try {
            return repository
                    .findById(id)
                    .map(TeamMapper.INSTANCE::asDTO);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @Override
    public List<TeamDTO> findByUser(Long id) {
        try {
            Optional<UserEntity> optional = userRepository.findById(id);

            return optional
                    .map(userEntity -> repository
                            .findTeamByUsersIsIn(List.of(userEntity))
                            .stream()
                            .map(TeamMapper.INSTANCE::asDTO)
                            .collect(Collectors.toList()))
                    .orElse(null);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @Override
    public List<TeamDTO> findAll() throws NotFoundException {
        try {
            return repository
                    .findAll()
                    .stream()
                    .map(TeamMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @Override
    public Page<TeamDTO> findAll(Pageable pageable) throws NotFoundException {
        try {
            Page<Team> entityPage = repository.findAll(pageable);
            List<TeamDTO> entities = entityPage
                    .getContent()
                    .stream()
                    .map(TeamMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());

            return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @Override
    public TeamDTO update(TeamDTO entity, Long id) throws NotUpdatedException {
        try {
            Optional<TeamDTO> optional = findById(id);

            if (optional.isPresent()) {
                Team team = TeamMapper.INSTANCE.fromDtoToEntity(optional.get());

                team.setName(entity.getName());
                team.setUsers(entity
                        .getUsers()
                        .stream()
                        .map(UserMapper.INSTANCE::fromLightDtoToEntity)
                        .collect(Collectors.toList()));
                team.setSharedAgendas(entity
                        .getSharedAgendas()
                        .stream()
                        .map(AgendaMapper.INSTANCE::fromLightDtoToEntity)
                        .collect(Collectors.toList()));

                return save(TeamMapper.INSTANCE.asDTO(team));
            } else {
                throw new Exception("Ressource not found...");
            }
        } catch (Exception e) {
            throw new NotUpdatedException();
        }
    }
}