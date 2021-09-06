package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.api.models.ScheduleDTO;
import eu.busi.myplanning.api.models.ScheduleLightDTO;
import eu.busi.myplanning.domain.models.Scheduling;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScheduleMapper extends GenericMapper<Scheduling, ScheduleDTO, ScheduleLightDTO> {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);
}