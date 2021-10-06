package eu.busi.myplanning.domain.services;


import eu.busi.myplanning.api.models.TeamDTO;

import java.util.List;

/**
 * The interface Team service.
 */
public interface TeamService extends GenericService<TeamDTO, Long> {
    /**
     * Find by user list.
     *
     * @param id the id
     * @return the list
     */
    List<TeamDTO> findByUser(Long id);
}