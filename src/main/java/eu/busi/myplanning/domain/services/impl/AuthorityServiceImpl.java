package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.domain.models.Authority;
import eu.busi.myplanning.domain.repositories.AuthorityRepository;
import eu.busi.myplanning.domain.services.AuthorityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {
    private final AuthorityRepository repository;

    public AuthorityServiceImpl(AuthorityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Authority save(Authority entity) {
        return repository.save(entity);
    }

    @Override
    public List<Authority> save(List<Authority> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public boolean deleteById(Long id) {
        repository.deleteById(id);

        return !repository.existsById(id);
    }

    @Override
    public Authority findById(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Authority> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Authority> findAll(Pageable pageable) {
        Page<Authority> entityPage = repository.findAll(pageable);
        List<Authority> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Authority update(Authority entity, Long id) {
        Authority authority = findById(id);

        return save(entity);
    }
}