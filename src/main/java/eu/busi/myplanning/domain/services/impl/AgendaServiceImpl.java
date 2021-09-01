package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.domain.models.Agenda;
import eu.busi.myplanning.domain.models.UserEntity;
import eu.busi.myplanning.domain.repositories.AgendaRepository;
import eu.busi.myplanning.domain.repositories.UserRepository;
import eu.busi.myplanning.domain.services.AgendaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
    public Agenda save(Agenda entity) {
        return repository.save(entity);
    }

    @Override
    public List<Agenda> save(List<Agenda> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public boolean deleteById(Long id) {
        repository.deleteById(id);

        return !repository.existsById(id);
    }

    @Override
    public Agenda findById(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Agenda> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Agenda> findAll(Pageable pageable) {
        Page<Agenda> entityPage = repository.findAll(pageable);
        List<Agenda> entities = entityPage.getContent();

        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Agenda update(Agenda entity, Long id) {
        Agenda agenda = findById(id);

        return save(entity);
    }

    @Override
    public List<Agenda> findByUser(Long id) {
        UserEntity user = userRepository.getById(id);

        return repository.findAgendaByUser(user);
    }

    @Override
    public List<Agenda> findSharedAgendasByUser(Long id) {
        Optional<UserEntity> optional = userRepository.findById(id);

        return optional.map(userEntity -> repository.findAgendaBySharedUsersIsIn(List.of(userEntity))).orElse(null);
    }
}