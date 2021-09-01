package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.domain.models.UserEntity;
import eu.busi.myplanning.models.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * The interface User mapper.
 */
@Mapper
public interface UserMapper extends GenericMapper<UserEntity, UserDTO> {
    /**
     * The constant INSTANCE.
     */
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}