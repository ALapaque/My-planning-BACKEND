package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.domain.models.Schedule;
import eu.busi.myplanning.domain.repositories.ScheduleRepository;
import eu.busi.myplanning.domain.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepository repository;

    @Override
    public Schedule save(Schedule entity) {
        return repository.save(entity);
    }

    @Override
    public List<Schedule> save(List<Schedule> entities) {
        return (List<Schedule>) repository.saveAll(entities);
    }

    @Override
    public boolean deleteById(Long id) {
        repository.deleteById(id);

        return !repository.existsById(id);
    }

    @Override
    public Schedule findById(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Schedule> findAll() {
        return (List<Schedule>) repository.findAll();
    }

    @Override
    public Page<Schedule> findAll(Pageable pageable) {
        Page<Schedule> entityPage = repository.findAll(pageable);
        List<Schedule> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Schedule update(Schedule entity, Long id) {
        Schedule schedule = findById(id);

        return save(entity);
    }
}