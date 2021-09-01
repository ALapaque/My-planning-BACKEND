package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.domain.models.Team;
import eu.busi.myplanning.domain.repositories.TeamRepository;
import eu.busi.myplanning.domain.services.TeamService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    private final TeamRepository repository;

    public TeamServiceImpl(TeamRepository repository) {
        this.repository = repository;
    }

    @Override
    public Team save(Team entity) {
        return repository.save(entity);
    }

    @Override
    public List<Team> save(List<Team> entities) {
        return (List<Team>) repository.saveAll(entities);
    }

    @Override
    public boolean deleteById(Long id) {
        repository.deleteById(id);

        return !repository.existsById(id);
    }

    @Override
    public Team findById(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Team> findAll() {
        return (List<Team>) repository.findAll();
    }

    @Override
    public Page<Team> findAll(Pageable pageable) {
        Page<Team> entityPage = repository.findAll(pageable);
        List<Team> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Team update(Team entity, Long id) {
        Team team = findById(id);

        return save(entity);
    }
}