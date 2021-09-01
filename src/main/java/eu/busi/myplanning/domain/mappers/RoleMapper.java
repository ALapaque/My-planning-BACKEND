package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.domain.models.Role;
import eu.busi.myplanning.models.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper extends GenericMapper<Role, RoleDTO> {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
}