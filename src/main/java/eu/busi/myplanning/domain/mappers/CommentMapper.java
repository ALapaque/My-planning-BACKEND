package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.domain.models.Comment;
import eu.busi.myplanning.models.CommentDTO;
import eu.busi.myplanning.models.CommentLightDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper extends GenericMapper<Comment, CommentDTO, CommentLightDTO> {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);
}