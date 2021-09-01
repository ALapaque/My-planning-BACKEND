package eu.busi.myplanning.domain.repositories;

import eu.busi.myplanning.domain.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Comment repository.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}