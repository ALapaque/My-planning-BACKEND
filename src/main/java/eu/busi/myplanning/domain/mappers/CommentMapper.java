package eu.busi.myplanning.domain.mappers;

import eu.busi.myplanning.domain.models.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper extends GenericMapper<Comment, Object> {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);
}