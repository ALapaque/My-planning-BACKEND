package eu.busi.myplanning.domain.controllers;

import eu.busi.myplanning.api.CommentApi;
import eu.busi.myplanning.models.CommentDTO;
import eu.busi.myplanning.models.PageCommentDTO;
import eu.busi.myplanning.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CommentController implements CommentApi {

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