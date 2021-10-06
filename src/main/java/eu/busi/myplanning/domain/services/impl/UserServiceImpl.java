package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.api.models.UserDTO;
import eu.busi.myplanning.domain.mappers.CardMapper;
import eu.busi.myplanning.domain.mappers.RoleMapper;
import eu.busi.myplanning.domain.mappers.TeamMapper;
import eu.busi.myplanning.domain.mappers.UserMapper;
import eu.busi.myplanning.domain.models.Agenda;
import eu.busi.myplanning.domain.models.UserEntity;
import eu.busi.myplanning.domain.repositories.CardRepository;
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
    private final CardRepository cardRepository;

    /**
     * Instantiates a new User service.
     *
     * @param repository     the repository
     * @param cardRepository the card repository
     */
    public UserServiceImpl(UserRepository repository, CardRepository cardRepository) {
        this.repository = repository;
        this.cardRepository = cardRepository;
    }

    /**
     * save a user
     * @param entity the entity
     * @return
     * @throws NotSavedException
     */
    @Override
    public UserDTO save(UserDTO entity) throws NotSavedException {
        try {
            UserEntity user = this.initDefaultUser(UserMapper.INSTANCE.fromDtoToEntity(entity));

            return UserMapper
                    .INSTANCE
                    .asDTO(repository.save(user));
        } catch (Exception e) {
            throw new NotSavedException();
        }
    }

    /**
     * save a list of users
     * @param entities the entities
     * @return
     * @throws NotSavedException
     */
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

    /**
     * delete a user by it's id
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
     * find a user by an id
     * @param id the id
     * @return
     * @throws NotFoundException
     */
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

    /**
     * find a user by its email or username
     * @param usernameOrEmail the username or email
     * @return
     */
    @Override
    public Optional<UserDTO> findByUsernameOrEmail(String usernameOrEmail) {
        try {
            return repository
                    .findByEmailOrUsername(usernameOrEmail, usernameOrEmail)
                    .map(UserMapper.INSTANCE::asDTO);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    /**
     * find all users
     * @return
     * @throws NotFoundException
     */
    @Override
    public List<UserDTO> findAll() throws NotFoundException {
        try {
            return repository
                    .findAllByOrderByFirstNameAsc()
                    .stream()
                    .map(UserMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    /**
     * find all users of an organization
     * @param organization the organization
     * @return
     */
    @Override
    public List<UserDTO> findAllByOrganization(String organization) {
        try {
            return repository
                    .findAllByOrganizationOrderByFirstNameAsc(organization)
                    .stream()
                    .map(UserMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    /**
     * find all users from a pageable object
     * @param pageable the pageable
     * @return
     * @throws NotFoundException
     */
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

    /**
     * update a user
     * @param entity the entity
     * @param id     the id
     * @return
     * @throws NotUpdatedException
     */
    @Override
    public UserDTO update(UserDTO entity, Long id) throws NotUpdatedException {
        try {
            Optional<UserDTO> optional = findById(id);

            if (optional.isPresent()) {
                UserEntity user = UserMapper.INSTANCE.fromDtoToEntity(optional.get());

                user.setFirstName(entity.getFirstName());
                user.setLastName(entity.getLastName());
                user.setEmail(entity.getEmail());
                if (!entity.getPassword().isEmpty()) {
                    user.setPassword(entity.getPassword());
                }
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

                return UserMapper.INSTANCE.asDTO(repository.save(user));
            } else {
                throw new Exception("Ressource not found...");
            }
        } catch (Exception e) {
            throw new NotUpdatedException();
        }
    }

    /**
     * Init default user user entity.
     *
     * @param user the user
     * @return the user entity
     */
    public UserEntity initDefaultUser(UserEntity user) {
        user.setCards(cardRepository.findAll());
        Agenda defaultAgenda = Agenda.defaultAgenda();
        defaultAgenda.setUser(user);
        user.setAgendas(List.of(defaultAgenda));

        return user;
    }
}