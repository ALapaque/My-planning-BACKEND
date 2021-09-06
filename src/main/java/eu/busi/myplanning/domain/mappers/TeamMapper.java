package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.domain.dto.TeamDTO;
import eu.busi.myplanning.domain.dto.TeamLightDTO;
import eu.busi.myplanning.domain.models.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeamMapper extends GenericMapper<Team, TeamDTO, TeamLightDTO> {
    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);
}