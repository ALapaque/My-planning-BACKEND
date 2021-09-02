package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.AgendaApi;
import eu.busi.myplanning.domain.services.impl.AgendaServiceImpl;
import eu.busi.myplanning.exceptions.NotDeletedException;
import eu.busi.myplanning.exceptions.NotFoundException;
import eu.busi.myplanning.exceptions.NotSavedException;
import eu.busi.myplanning.models.AgendaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
public class AgendaController implements AgendaApi {
    private final AgendaServiceImpl agendaService;

    /**
     * Instanciation of the repository providing the service
     *
     * @param agendaService
     */
    public AgendaController(AgendaServiceImpl agendaService) {
        this.agendaService = agendaService;
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
    public ResponseEntity<Boolean> deleteAgenda(Long id) {
        try {
            return new ResponseEntity<>(this.agendaService.deleteById(id), HttpStatus.OK);
        } catch (NotDeletedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<AgendaDTO> findAgenda(Long id) {
        try {
            Optional<AgendaDTO> optional = this.agendaService.findById(id);

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
    public ResponseEntity<List<AgendaDTO>> findAgendas() {
        try {
            return new ResponseEntity<>(this.agendaService.findAll(), HttpStatus.OK);
        } catch (NotFoundException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<AgendaDTO>> findAgendasByUser(Long id) {
        try {
            return new ResponseEntity<>(this.agendaService.findByUser(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<AgendaDTO>> findSharedAgendasByUser(Long id) {
        try {
            return new ResponseEntity<>(this.agendaService.findSharedAgendasByUser(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<AgendaDTO> saveAgenda(AgendaDTO body) {
        try {
            return new ResponseEntity<>(this.agendaService.save(body), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
