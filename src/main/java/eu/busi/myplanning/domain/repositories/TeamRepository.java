package eu.busi.myplanning.domain.repositories;

import eu.busi.myplanning.domain.models.Team;
import eu.busi.myplanning.domain.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Team repository.
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    /**
     * Find team by users is in order by name asc list.
     *
     * @param users the users
     * @return the list
     */
    List<Team> findTeamByUsersIsInOrderByNameAsc(List<UserEntity> users);
}