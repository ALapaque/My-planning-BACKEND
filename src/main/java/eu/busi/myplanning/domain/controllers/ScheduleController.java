package eu.busi.myplanning.domain.controllers;

import eu.busi.myplanning.api.ScheduleApi;
import eu.busi.myplanning.models.PageScheduleDTO;
import eu.busi.myplanning.models.Pageable;
import eu.busi.myplanning.models.ScheduleDTO;
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
public class ScheduleController implements ScheduleApi {

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