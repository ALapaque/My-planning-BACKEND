package eu.busi.myplanning.domain.repositories;

import eu.busi.myplanning.domain.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Team repository.
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}