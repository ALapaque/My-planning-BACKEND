package eu.busi.myplanning.domain.services;

import eu.busi.myplanning.exceptions.NotFoundException;
import eu.busi.myplanning.models.AgendaDTO;

import java.util.List;

/**
 * The interface Agenda service.
 */
public interface AgendaService extends GenericService<AgendaDTO, Long> {
    List<AgendaDTO> findByUser(Long id) throws NotFoundException;
    List<AgendaDTO> findSharedAgendasByUser(Long id) throws NotFoundException;
}