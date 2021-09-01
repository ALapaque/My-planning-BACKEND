package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.domain.models.Authority;
import eu.busi.myplanning.models.AuthorityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorityMapper extends GenericMapper<Authority, AuthorityDTO> {
    AuthorityMapper INSTANCE = Mappers.getMapper(AuthorityMapper.class);
}