package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.domain.models.UserEntity;
import eu.busi.myplanning.domain.repositories.UserRepository;
import eu.busi.myplanning.domain.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
    public UserEntity save(UserEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<UserEntity> save(List<UserEntity> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public boolean deleteById(Long id) {
        repository.deleteById(id);

        return !repository.existsById(id);
    }

    @Override
    public UserEntity findById(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<UserEntity> findAll(Pageable pageable) {
        Page<UserEntity> entityPage = repository.findAll(pageable);
        List<UserEntity> entities = entityPage.getContent();

        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public UserEntity update(UserEntity entity, Long id) {
        UserEntity user = findById(id);

        return save(entity);
    }
}