package eu.busi.myplanning.domain.controllers;

import eu.busi.myplanning.api.AgendaApi;
import eu.busi.myplanning.domain.services.impl.AgendaServiceImpl;
import eu.busi.myplanning.models.AgendaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class AgendaController implements AgendaApi {
    private final AgendaServiceImpl agendaService;

    public AgendaController(AgendaServiceImpl agendaService) {
        this.agendaService = agendaService;
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<AgendaDTO>> find() {
        return new ResponseEntity<>(this.agendaService.findAll(), HttpStatus.OK);
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
