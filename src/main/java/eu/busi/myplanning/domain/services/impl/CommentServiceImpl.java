package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.domain.models.Comment;
import eu.busi.myplanning.domain.repositories.CommentRepository;
import eu.busi.myplanning.domain.services.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;

    public CommentServiceImpl(CommentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Comment save(Comment entity) {
        return repository.save(entity);
    }

    @Override
    public List<Comment> save(List<Comment> entities) {
        return (List<Comment>) repository.saveAll(entities);
    }

    @Override
    public boolean deleteById(Long id) {
        repository.deleteById(id);

        return !repository.existsById(id);
    }

    @Override
    public Comment findById(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Comment> findAll() {
        return (List<Comment>) repository.findAll();
    }

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        Page<Comment> entityPage = repository.findAll(pageable);
        List<Comment> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Comment update(Comment entity, Long id) {
        Comment comment = findById(id);

        return save(entity);
    }
}