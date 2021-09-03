package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.domain.dto.RoleDTO;
import eu.busi.myplanning.domain.dto.RoleLightDTO;
import eu.busi.myplanning.domain.models.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper extends GenericMapper<Role, RoleDTO, RoleLightDTO> {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
}