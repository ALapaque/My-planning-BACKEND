package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.api.models.RoleDTO;
import eu.busi.myplanning.domain.mappers.AuthorityMapper;
import eu.busi.myplanning.domain.mappers.RoleMapper;
import eu.busi.myplanning.domain.models.Role;
import eu.busi.myplanning.domain.repositories.RoleRepository;
import eu.busi.myplanning.domain.services.RoleService;
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
 * The type Role service.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    /**
     * Instantiates a new Role service.
     *
     * @param repository the repository
     */
    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    /**
     * save a role
     * @param entity the entity
     * @return
     * @throws NotSavedException
     */
    @Override
    public RoleDTO save(RoleDTO entity) throws NotSavedException {
        try {
            return RoleMapper
                    .INSTANCE
                    .asDTO(repository
                            .save(RoleMapper
                                    .INSTANCE
                                    .fromDtoToEntity(entity)));
        } catch (Exception e) {
            throw new NotSavedException();
        }
    }

    /**
     * save a list of roles
     * @param entities the entities
     * @return
     * @throws NotSavedException
     */
    @Override
    public List<RoleDTO> save(List<RoleDTO> entities) throws NotSavedException {
        try {
            List<Role> roles = entities
                    .stream()
                    .map(RoleMapper.INSTANCE::fromDtoToEntity)
                    .collect(Collectors.toList());

            return repository
                    .saveAll(roles)
                    .stream()
                    .map(RoleMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NotSavedException();
        }
    }

    /**
     * delete a role by an id
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
     * find a role by an id
     * @param id the id
     * @return
     * @throws NotFoundException
     */
    @Override
    public Optional<RoleDTO> findById(Long id) throws NotFoundException {
        try {
            return repository
                    .findById(id)
                    .map(RoleMapper.INSTANCE::asDTO);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    /**
     * find all roles
     * @return
     * @throws NotFoundException
     */
    @Override
    public List<RoleDTO> findAll() throws NotFoundException {
        try {
            return repository
                    .findAll()
                    .stream()
                    .map(RoleMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    /**
     * find all roles from a pageable object
     * @param pageable the pageable
     * @return
     * @throws NotFoundException
     */
    @Override
    public Page<RoleDTO> findAll(Pageable pageable) throws NotFoundException {
        try {
            Page<Role> entityPage = repository.findAll(pageable);
            List<RoleDTO> entities = entityPage
                    .getContent()
                    .stream()
                    .map(RoleMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());

            return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    /**
     * update a role
     * @param entity the entity
     * @param id     the id
     * @return
     * @throws NotUpdatedException
     */
    @Override
    public RoleDTO update(RoleDTO entity, Long id) throws NotUpdatedException {
        try {
            Optional<RoleDTO> optional = findById(id);

            if (optional.isPresent()) {
                Role role = RoleMapper.INSTANCE.fromDtoToEntity(optional.get());

                role.setName(entity.getName());
                role.setAuthorities(entity
                        .getAuthorities()
                        .stream()
                        .map(AuthorityMapper.INSTANCE::fromLightDtoToEntity)
                        .collect(Collectors.toList()));

                return save(RoleMapper.INSTANCE.asDTO(role));
            } else {
                throw new Exception("Ressource not found...");
            }
        } catch (Exception e) {
            throw new NotUpdatedException();
        }
    }
}