package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.domain.mappers.AuthorityMapper;
import eu.busi.myplanning.domain.mappers.RoleMapper;
import eu.busi.myplanning.domain.models.Role;
import eu.busi.myplanning.domain.repositories.RoleRepository;
import eu.busi.myplanning.domain.services.RoleService;
import eu.busi.myplanning.exceptions.NotDeletedException;
import eu.busi.myplanning.exceptions.NotFoundException;
import eu.busi.myplanning.exceptions.NotSavedException;
import eu.busi.myplanning.exceptions.NotUpdatedException;
import eu.busi.myplanning.models.RoleDTO;
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
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

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
    public Optional<RoleDTO> findById(Long id) throws NotFoundException {
        try {
            return repository
                    .findById(id)
                    .map(RoleMapper.INSTANCE::asDTO);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

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