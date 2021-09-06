package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.controllers.AgendaApi;
import eu.busi.myplanning.api.models.AgendaDTO;
import eu.busi.myplanning.domain.services.impl.AgendaServiceImpl;
import eu.busi.myplanning.exceptions.NotDeletedException;
import eu.busi.myplanning.exceptions.NotFoundException;
import eu.busi.myplanning.exceptions.NotSavedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> findAgenda(Long id) {
        try {
            Optional<AgendaDTO> optional = this.agendaService.findById(id);

            if (optional.isPresent()) {
                return new ResponseEntity<>(optional.get(), HttpStatus.OK);
            } else {
                throw new NotFoundException();
            }
        } catch (NotFoundException e) {
            return e.responseEntity();
        }
    }


    @Override
    public ResponseEntity<Object> findAgendas() {
        try {
            return new ResponseEntity<>(this.agendaService.findAll(), HttpStatus.OK);
        } catch (NotFoundException e) {
            return e.responseEntity();
        }
    }

    @Override
    public ResponseEntity<Object> findAgendasByUser(Long id) {
        try {
            return new ResponseEntity<>(this.agendaService.findByUser(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return e.responseEntity();
        }
    }

    @Override
    public ResponseEntity<Object> findSharedAgendasByUser(Long id) {
        try {
            return new ResponseEntity<>(this.agendaService.findSharedAgendasByUser(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return e.responseEntity();
        }
    }

    @Override
    public ResponseEntity<Object> saveAgenda(AgendaDTO body) {
        try {
            return new ResponseEntity<>(this.agendaService.save(body), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            return e.responseEntity();
        }
    }
}
