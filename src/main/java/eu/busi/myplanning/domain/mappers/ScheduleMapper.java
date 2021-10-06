package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.api.models.ScheduleDTO;
import eu.busi.myplanning.api.models.ScheduleLightDTO;
import eu.busi.myplanning.domain.models.Scheduling;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * The interface Schedule mapper.
 */
@Mapper
public interface ScheduleMapper extends GenericMapper<Scheduling, ScheduleDTO, ScheduleLightDTO> {
    /**
     * The constant INSTANCE.
     */
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);
}