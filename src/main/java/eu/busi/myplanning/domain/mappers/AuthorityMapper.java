package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.domain.models.Authority;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorityMapper extends GenericMapper<Authority, Object> {
    AuthorityMapper INSTANCE = Mappers.getMapper(AuthorityMapper.class);
}