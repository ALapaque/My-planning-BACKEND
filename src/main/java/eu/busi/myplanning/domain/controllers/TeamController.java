package eu.busi.myplanning.domain.controllers;

import eu.busi.myplanning.api.TeamApi;
import eu.busi.myplanning.models.PageTeamDTO;
import eu.busi.myplanning.models.Pageable;
import eu.busi.myplanning.models.TeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TeamController implements TeamApi {

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