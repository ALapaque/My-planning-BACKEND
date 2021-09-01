package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.domain.models.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * The interface User mapper.
 */
@Mapper
public interface UserMapper extends GenericMapper<UserEntity, Object> {
    /**
     * The constant INSTANCE.
     */
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}