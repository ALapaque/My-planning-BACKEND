package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.domain.models.Role;
import eu.busi.myplanning.domain.repositories.RoleRepository;
import eu.busi.myplanning.domain.services.RoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role save(Role entity) {
        return repository.save(entity);
    }

    @Override
    public List<Role> save(List<Role> entities) {
        return (List<Role>) repository.saveAll(entities);
    }

    @Override
    public boolean deleteById(Long id) {
        repository.deleteById(id);

        return !repository.existsById(id);
    }

    @Override
    public Role findById(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Role> findAll() {
        return (List<Role>) repository.findAll();
    }

    @Override
    public Page<Role> findAll(Pageable pageable) {
        Page<Role> entityPage = repository.findAll(pageable);
        List<Role> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Role update(Role entity, Long id) {
        Role role = findById(id);

        return save(entity);
    }
}