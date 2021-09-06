package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.api.models.EventDTO;
import eu.busi.myplanning.api.models.EventLightDTO;
import eu.busi.myplanning.domain.models.Event;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventMapper extends GenericMapper<Event, EventDTO, EventLightDTO> {
    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);
}