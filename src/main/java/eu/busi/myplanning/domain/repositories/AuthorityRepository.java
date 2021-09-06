package eu.busi.myplanning.domain.repositories;

import eu.busi.myplanning.domain.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Authority repository.
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}