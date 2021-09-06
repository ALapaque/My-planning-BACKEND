package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.api.models.AuthorityDTO;
import eu.busi.myplanning.api.models.AuthorityLightDTO;
import eu.busi.myplanning.domain.models.Authority;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorityMapper extends GenericMapper<Authority, AuthorityDTO, AuthorityLightDTO> {
    AuthorityMapper INSTANCE = Mappers.getMapper(AuthorityMapper.class);
}