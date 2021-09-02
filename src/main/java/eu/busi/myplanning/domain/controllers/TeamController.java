package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.TeamApi;
import eu.busi.myplanning.models.PageTeamDTO;
import eu.busi.myplanning.models.Pageable;
import eu.busi.myplanning.models.TeamDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class TeamController implements TeamApi {

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Void> deleteTeam(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<TeamDTO> findTeam(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<PageTeamDTO> listTeams(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<TeamDTO> saveTeam(TeamDTO body) {
        return null;
    }

    @Override
    public ResponseEntity<TeamDTO> updateTeam(TeamDTO body, Long id) {
        return null;
    }
}