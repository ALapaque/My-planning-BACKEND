package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.domain.models.Role;
import eu.busi.myplanning.models.RoleDTO;
import eu.busi.myplanning.models.RoleLightDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper extends GenericMapper<Role, RoleDTO, RoleLightDTO> {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
}