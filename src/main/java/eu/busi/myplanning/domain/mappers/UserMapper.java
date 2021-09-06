package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.api.models.UserDTO;
import eu.busi.myplanning.api.models.UserLightDTO;
import eu.busi.myplanning.domain.models.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * The interface User mapper.
 */
@Mapper
public interface UserMapper extends GenericMapper<UserEntity, UserDTO, UserLightDTO> {
    /**
     * The constant INSTANCE.
     */
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}