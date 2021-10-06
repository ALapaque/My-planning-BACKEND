package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.api.models.TeamDTO;
import eu.busi.myplanning.api.models.TeamLightDTO;
import eu.busi.myplanning.domain.models.Team;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * The interface Team mapper.
 */
@Mapper
public interface TeamMapper extends GenericMapper<Team, TeamDTO, TeamLightDTO> {
    /**
     * The constant INSTANCE.
     */
    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);
}