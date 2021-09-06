package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.api.models.UserDTO;
import eu.busi.myplanning.domain.mappers.CardMapper;
import eu.busi.myplanning.domain.mappers.RoleMapper;
import eu.busi.myplanning.domain.mappers.TeamMapper;
import eu.busi.myplanning.domain.mappers.UserMapper;
import eu.busi.myplanning.domain.models.UserEntity;
import eu.busi.myplanning.domain.repositories.UserRepository;
import eu.busi.myplanning.domain.services.UserService;
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
 * The type User service.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDTO save(UserDTO entity) throws NotSavedException {
        try {
            return UserMapper
                    .INSTANCE
                    .asDTO(repository
                            .save(UserMapper
                                    .INSTANCE
                                    .fromDtoToEntity(entity)));
        } catch (Exception e) {
            throw new NotSavedException();
        }
    }

    @Override
    public List<UserDTO> save(List<UserDTO> entities) throws NotSavedException {
        try {
            List<UserEntity> users = entities
                    .stream()
                    .map(UserMapper.INSTANCE::fromDtoToEntity)
                    .collect(Collectors.toList());

            return repository
                    .saveAll(users)
                    .stream()
                    .map(UserMapper.INSTANCE::asDTO)
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
    public Optional<UserDTO> findById(Long id) throws NotFoundException {
        try {
            return repository
                    .findById(id)
                    .map(UserMapper.INSTANCE::asDTO);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @Override
    public List<UserDTO> findAll() throws NotFoundException {
        try {
            return repository
                    .findAll()
                    .stream()
                    .map(UserMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @Override
    public Page<UserDTO> findAll(Pageable pageable) throws NotFoundException {
        try {
            Page<UserEntity> entityPage = repository.findAll(pageable);
            List<UserDTO> entities = entityPage
                    .getContent()
                    .stream()
                    .map(UserMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());

            return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @Override
    public UserDTO update(UserDTO entity, Long id) throws NotUpdatedException {
        try {
            Optional<UserDTO> optional = findById(id);

            if (optional.isPresent()) {
                UserEntity user = UserMapper.INSTANCE.fromDtoToEntity(optional.get());

                user.setFirstName(entity.getFirstName());
                user.setLastName(entity.getLastName());
                user.setEmail(entity.getEmail());
                user.setPassword(entity.getPassword());
                user.setRole(RoleMapper.INSTANCE.fromLightDtoToEntity(entity.getRole()));
                user.setTeams(entity
                        .getTeams()
                        .stream()
                        .map(TeamMapper.INSTANCE::fromLightDtoToEntity)
                        .collect(Collectors.toList()));
                user.setCards(entity
                        .getCards()
                        .stream()
                        .map(CardMapper.INSTANCE::fromLightDtoToEntity)
                        .collect(Collectors.toList()));

                return save(UserMapper.INSTANCE.asDTO(user));
            } else {
                throw new Exception("Ressource not found...");
            }
        } catch (Exception e) {
            throw new NotUpdatedException();
        }
    }
}