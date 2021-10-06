package eu.busi.myplanning.domain.services;

import eu.busi.myplanning.api.models.AgendaDTO;
import eu.busi.myplanning.exceptions.NotFoundException;

import java.util.List;

/**
 * The interface Agenda service.
 */
public interface AgendaService extends GenericService<AgendaDTO, Long> {
    /**
     * Find by user list.
     *
     * @param id the id
     * @return the list
     * @throws NotFoundException the not found exception
     */
    List<AgendaDTO> findByUser(Long id) throws NotFoundException;

    /**
     * Find shared agendas by user list.
     *
     * @param id the id
     * @return the list
     * @throws NotFoundException the not found exception
     */
    List<AgendaDTO> findSharedAgendasByUser(Long id) throws NotFoundException;
}