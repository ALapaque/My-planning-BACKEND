package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.api.models.CommentDTO;
import eu.busi.myplanning.domain.mappers.CommentMapper;
import eu.busi.myplanning.domain.mappers.UserMapper;
import eu.busi.myplanning.domain.models.Comment;
import eu.busi.myplanning.domain.repositories.CommentRepository;
import eu.busi.myplanning.domain.services.CommentService;
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

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;

    public CommentServiceImpl(CommentRepository repository) {
        this.repository = repository;
    }

    @Override
    public CommentDTO save(CommentDTO entity) throws NotSavedException {
        try {
            return CommentMapper
                    .INSTANCE
                    .asDTO(repository
                            .save(CommentMapper
                                    .INSTANCE
                                    .fromDtoToEntity(entity)));
        } catch (Exception e) {
            throw new NotSavedException();
        }
    }

    @Override
    public List<CommentDTO> save(List<CommentDTO> entities) throws NotSavedException {
        try {
            List<Comment> comments = entities
                    .stream()
                    .map(CommentMapper.INSTANCE::fromDtoToEntity)
                    .collect(Collectors.toList());

            return repository
                    .saveAll(comments)
                    .stream()
                    .map(CommentMapper.INSTANCE::asDTO)
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
    public Optional<CommentDTO> findById(Long id) throws NotFoundException {
        try {
            return repository
                    .findById(id)
                    .map(CommentMapper.INSTANCE::asDTO);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @Override
    public List<CommentDTO> findAll() throws NotFoundException {
        try {
            return repository
                    .findAll()
                    .stream()
                    .map(CommentMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    public Page<CommentDTO> findAll(Pageable pageable) throws NotFoundException {
        try {
            Page<Comment> entityPage = repository.findAll(pageable);
            List<CommentDTO> entities = entityPage
                    .getContent()
                    .stream()
                    .map(CommentMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());

            return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @Override
    public CommentDTO update(CommentDTO entity, Long id) throws NotUpdatedException {
        try {
            Optional<CommentDTO> optional = findById(id);

            if (optional.isPresent()) {
                Comment comment = CommentMapper.INSTANCE.fromDtoToEntity(optional.get());

                comment.setContent(entity.getContent());
                comment.setUser(UserMapper.INSTANCE.fromLightDtoToEntity(entity.getUser()));

                return save(CommentMapper.INSTANCE.asDTO(comment));
            } else {
                throw new Exception("Ressource not found...");
            }
        } catch (Exception e) {
            throw new NotUpdatedException();
        }
    }
}