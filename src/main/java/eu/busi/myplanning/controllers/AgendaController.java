package eu.busi.myplanning.controllers;

import eu.busi.myplanning.api.AgendaApi;
import eu.busi.myplanning.models.AgendaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class AgendaController implements AgendaApi {
    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<AgendaDTO>> find() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AgendaDTO> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<AgendaDTO>> findByUser(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<AgendaDTO>> findSharedAgendasByUser(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<AgendaDTO> save(AgendaDTO body) {
        return null;
    }
}
