package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.controllers.TeamApi;
import eu.busi.myplanning.api.models.Pageable;
import eu.busi.myplanning.api.models.TeamDTO;
import eu.busi.myplanning.domain.services.impl.TeamServiceImpl;
import eu.busi.myplanning.domain.services.impl.UserServiceImpl;
import eu.busi.myplanning.exceptions.NotDeletedException;
import eu.busi.myplanning.exceptions.NotFoundException;
import eu.busi.myplanning.exceptions.NotSavedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class TeamController implements TeamApi {
    private final TeamServiceImpl teamService;
    private final UserServiceImpl userService;

    public TeamController(TeamServiceImpl teamService, UserServiceImpl userService) {
        this.teamService = teamService;
        this.userService = userService;
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
    public ResponseEntity<Boolean> deleteTeam(Long id) {
        try {
            return new ResponseEntity<>(this.teamService.deleteById(id), HttpStatus.OK);
        } catch (NotDeletedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> findTeam(Long id) {
        try {
            Optional<TeamDTO> optional = this.teamService.findById(id);

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
    public ResponseEntity<Object> findTeamsByUser(Long id) {
        try {
            return new ResponseEntity<>(this.teamService.findByUser(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> listTeams(Pageable pageable) {
        try {
            //PageTeamDTO page = new PageTeamDTO().content(this.teamService.findAll());

            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (NotFoundException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> saveTeam(TeamDTO body) {
        try {
            return new ResponseEntity<>(this.teamService.save(body), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> updateTeam(TeamDTO body, Long id) {
        try {
            return new ResponseEntity<>(this.teamService.update(body, id), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}