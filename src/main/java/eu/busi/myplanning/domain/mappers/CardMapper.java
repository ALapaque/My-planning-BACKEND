package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.domain.models.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper extends GenericMapper<Card, Object> {
    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);
}