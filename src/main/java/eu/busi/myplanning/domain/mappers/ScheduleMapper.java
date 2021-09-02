package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.domain.models.Scheduling;
import eu.busi.myplanning.models.ScheduleDTO;
import eu.busi.myplanning.models.ScheduleLightDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScheduleMapper extends GenericMapper<Scheduling, ScheduleDTO, ScheduleLightDTO> {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);
}