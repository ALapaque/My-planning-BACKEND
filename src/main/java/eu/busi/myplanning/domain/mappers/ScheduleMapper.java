package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.domain.models.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScheduleMapper extends GenericMapper<Schedule, Object> {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);
}