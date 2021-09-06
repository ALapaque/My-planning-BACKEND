package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.controllers.CommentApi;
import eu.busi.myplanning.api.models.CommentDTO;
import eu.busi.myplanning.api.models.Pageable;
import eu.busi.myplanning.domain.services.impl.CommentServiceImpl;
import eu.busi.myplanning.exceptions.NotDeletedException;
import eu.busi.myplanning.exceptions.NotFoundException;
import eu.busi.myplanning.exceptions.NotSavedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class CommentController implements CommentApi {
    private final CommentServiceImpl commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Boolean> deleteComment(Long id) {
        try {
            return new ResponseEntity<>(this.commentService.deleteById(id), HttpStatus.OK);
        } catch (NotDeletedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> findComment(Long id) {
        try {
            Optional<CommentDTO> optional = this.commentService.findById(id);

            if (optional.isPresent()) {
                return new ResponseEntity<>(optional.get(), HttpStatus.OK);
            } else {
                throw new NotFoundException();
            }
        } catch (NotFoundException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> listComments(Pageable pageable) {
        try {
            //PageCommentDTO page = new PageCommentDTO().content(this.commentService.findAll());

            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (NotFoundException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> saveComment(CommentDTO body) {
        try {
            return new ResponseEntity<>(this.commentService.save(body), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> updateComment(CommentDTO body, Long id) {
        try {
            return new ResponseEntity<>(this.commentService.update(body, id), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}