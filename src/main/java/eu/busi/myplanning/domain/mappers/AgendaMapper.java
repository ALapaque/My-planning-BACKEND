package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.domain.models.Agenda;
import eu.busi.myplanning.models.AgendaDTO;
import org.mapstruct.factory.Mappers;

public interface AgendaMapper extends GenericMapper<Agenda, AgendaDTO> {
    AgendaMapper INSTANCE = Mappers.getMapper(AgendaMapper.class);
}
