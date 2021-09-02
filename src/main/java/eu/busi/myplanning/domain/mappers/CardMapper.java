package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.domain.models.Card;
import eu.busi.myplanning.models.CardDTO;
import eu.busi.myplanning.models.CardLightDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper extends GenericMapper<Card, CardDTO, CardLightDTO> {
    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);
}