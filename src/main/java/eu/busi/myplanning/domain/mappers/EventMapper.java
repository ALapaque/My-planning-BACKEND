package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.domain.models.Event;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventMapper extends GenericMapper<Event, Object> {
    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);
}