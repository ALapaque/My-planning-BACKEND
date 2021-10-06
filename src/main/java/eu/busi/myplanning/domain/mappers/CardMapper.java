package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.api.models.CardDTO;
import eu.busi.myplanning.api.models.CardLightDTO;
import eu.busi.myplanning.domain.models.Card;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * The interface Card mapper.
 */
@Mapper
public interface CardMapper extends GenericMapper<Card, CardDTO, CardLightDTO> {
    /**
     * The constant INSTANCE.
     */
    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);
}