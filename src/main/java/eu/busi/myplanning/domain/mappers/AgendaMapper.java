package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.api.models.AgendaDTO;
import eu.busi.myplanning.api.models.AgendaLightDTO;
import eu.busi.myplanning.domain.models.Agenda;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AgendaMapper extends GenericMapper<Agenda, AgendaDTO, AgendaLightDTO> {
    AgendaMapper INSTANCE = Mappers.getMapper(AgendaMapper.class);
}