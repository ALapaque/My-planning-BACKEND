package eu.busi.myplanning.domain.controllers;

import eu.busi.myplanning.api.AgendaApi;
import eu.busi.myplanning.domain.services.impl.AgendaServiceImpl;
import eu.busi.myplanning.models.AgendaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgendaController implements AgendaApi {
    private final AgendaServiceImpl agendaService;

    /**
     * Instanciation of the repository providing the service
     * @param agendaService
     */
    public AgendaController(AgendaServiceImpl agendaService) {
        this.agendaService = agendaService;
    }

    @Override
    public ResponseEntity<Boolean> deleteAgenda(Long id) {
        try {
            return new ResponseEntity<>(agendaService.deleteById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Something wrong just happened", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<AgendaDTO> findAgenda(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<AgendaDTO>> findAgendas() {
        return null;
    }

    @Override
    public ResponseEntity<List<AgendaDTO>> findAgendasByUser(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<AgendaDTO>> findSharedAgendasByUser(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<AgendaDTO> saveAgenda(AgendaDTO body) {
        return null;
    }
}
