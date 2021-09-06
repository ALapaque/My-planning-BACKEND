package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.api.models.CommentDTO;
import eu.busi.myplanning.api.models.CommentLightDTO;
import eu.busi.myplanning.domain.models.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper extends GenericMapper<Comment, CommentDTO, CommentLightDTO> {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);
}