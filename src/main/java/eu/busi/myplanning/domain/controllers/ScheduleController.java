package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.ScheduleApi;
import eu.busi.myplanning.models.PageScheduleDTO;
import eu.busi.myplanning.models.Pageable;
import eu.busi.myplanning.models.ScheduleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class ScheduleController implements ScheduleApi {

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Void> deleteSchedule(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ScheduleDTO> findSchedule(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<PageScheduleDTO> listSchedules(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<ScheduleDTO> saveSchedule(ScheduleDTO body) {
        return null;
    }

    @Override
    public ResponseEntity<ScheduleDTO> updateSchedule(ScheduleDTO body, Long id) {
        return null;
    }
}