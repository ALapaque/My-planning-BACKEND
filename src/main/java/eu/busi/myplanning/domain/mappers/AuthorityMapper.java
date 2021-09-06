package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.domain.dto.AuthorityDTO;
import eu.busi.myplanning.domain.dto.AuthorityLightDTO;
import eu.busi.myplanning.domain.models.Authority;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorityMapper extends GenericMapper<Authority, AuthorityDTO, AuthorityLightDTO> {
    AuthorityMapper INSTANCE = Mappers.getMapper(AuthorityMapper.class);
}