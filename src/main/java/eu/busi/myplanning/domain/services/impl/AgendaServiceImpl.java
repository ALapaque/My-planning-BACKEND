package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.domain.mappers.AgendaMapper;
import eu.busi.myplanning.domain.repositories.AgendaRepository;
import eu.busi.myplanning.domain.services.AgendaService;
import eu.busi.myplanning.models.AgendaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService<AgendaDTO> {
    private final AgendaRepository agendaRepository;

    public AgendaServiceImpl(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @Override
    public List<AgendaDTO> findAll() {
        return AgendaMapper.INSTANCE.asDTOList(this.agendaRepository.findAll());
    }
}
