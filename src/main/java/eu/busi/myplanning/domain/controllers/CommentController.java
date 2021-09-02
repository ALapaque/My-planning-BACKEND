package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.CommentApi;
import eu.busi.myplanning.models.CommentDTO;
import eu.busi.myplanning.models.PageCommentDTO;
import eu.busi.myplanning.models.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class CommentController implements CommentApi {

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Void> deleteComment(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<CommentDTO> findComment(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<PageCommentDTO> listComments(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<CommentDTO> saveComment(CommentDTO body) {
        return null;
    }

    @Override
    public ResponseEntity<CommentDTO> updateComment(CommentDTO body, Long id) {
        return null;
    }
}