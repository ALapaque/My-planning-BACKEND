package eu.busi.myplanning.domain.services;


import eu.busi.myplanning.api.models.TeamDTO;

import java.util.List;

public interface TeamService extends GenericService<TeamDTO, Long> {
    List<TeamDTO> findByUser(Long id);
}