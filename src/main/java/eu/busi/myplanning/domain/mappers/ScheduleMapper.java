package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.domain.models.Schedule;
import eu.busi.myplanning.models.ScheduleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScheduleMapper extends GenericMapper<Schedule, ScheduleDTO> {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);
}