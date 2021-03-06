package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.api.models.AuthorityDTO;
import eu.busi.myplanning.domain.mappers.AuthorityMapper;
import eu.busi.myplanning.domain.mappers.RoleMapper;
import eu.busi.myplanning.domain.models.Authority;
import eu.busi.myplanning.domain.repositories.AuthorityRepository;
import eu.busi.myplanning.domain.services.AuthorityService;
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
 * The type Authority service.
 */
@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {
    private final AuthorityRepository repository;

    /**
     * Instantiates a new Authority service.
     *
     * @param repository the repository
     */
    public AuthorityServiceImpl(AuthorityRepository repository) {
        this.repository = repository;
    }

    /**
     * save an authority
     * @param entity the entity
     * @return
     * @throws NotSavedException
     */
    @Override
    public AuthorityDTO save(AuthorityDTO entity) throws NotSavedException {
        try {
            return AuthorityMapper
                    .INSTANCE
                    .asDTO(repository
                            .save(AuthorityMapper
                                    .INSTANCE
                                    .fromDtoToEntity(entity)));
        } catch (Exception e) {
            throw new NotSavedException();
        }
    }

    /**
     * save a list of authorities
     * @param entities the entities
     * @return
     * @throws NotSavedException
     */
    @Override
    public List<AuthorityDTO> save(List<AuthorityDTO> entities) throws NotSavedException {
        try {
            List<Authority> authorities = entities
                    .stream()
                    .map(AuthorityMapper.INSTANCE::fromDtoToEntity)
                    .collect(Collectors.toList());

            return repository
                    .saveAll(authorities)
                    .stream()
                    .map(AuthorityMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NotSavedException();
        }
    }

    /**
     * delete an authority by id
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
     * find an authority by id
     * @param id the id
     * @return
     * @throws NotFoundException
     */
    @Override
    public Optional<AuthorityDTO> findById(Long id) throws NotFoundException {
        try {
            return repository
                    .findById(id)
                    .map(AuthorityMapper.INSTANCE::asDTO);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    /**
     * find all authorities
     * @return
     */
    @Override
    public List<AuthorityDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(AuthorityMapper.INSTANCE::asDTO)
                .collect(Collectors.toList());
    }

    /**
     * find all from a pageable object
     * @param pageable the pageable
     * @return
     */
    @Override
    public Page<AuthorityDTO> findAll(Pageable pageable) {
        Page<Authority> entityPage = repository.findAll(pageable);
        List<AuthorityDTO> entities = entityPage
                .getContent()
                .stream()
                .map(AuthorityMapper.INSTANCE::asDTO)
                .collect(Collectors.toList());

        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    /**
     * update an authority
     * @param entity the entity
     * @param id     the id
     * @return
     * @throws NotUpdatedException
     */
    @Override
    public AuthorityDTO update(AuthorityDTO entity, Long id) throws NotUpdatedException {
        try {
            Optional<AuthorityDTO> optional = findById(id);

            if (optional.isPresent()) {
                Authority authority = AuthorityMapper.INSTANCE.fromDtoToEntity(optional.get());
                authority.setName(entity.getName());
                authority.setRoles(entity
                        .getRoles()
                        .stream()
                        .map(RoleMapper.INSTANCE::fromLightDtoToEntity)
                        .collect(Collectors.toList()));

                return save(AuthorityMapper.INSTANCE.asDTO(authority));
            } else {
                throw new Exception("Ressource not found...");
            }
        } catch (Exception e) {
            throw new NotUpdatedException();
        }
    }
}