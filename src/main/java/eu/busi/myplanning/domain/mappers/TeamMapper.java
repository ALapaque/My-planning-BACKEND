package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.domain.models.Team;
import eu.busi.myplanning.models.TeamDTO;
import eu.busi.myplanning.models.TeamLightDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeamMapper extends GenericMapper<Team, TeamDTO, TeamLightDTO> {
    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);
}