package eu.busi.myplanning.domain.repositories;

import eu.busi.myplanning.domain.models.Agenda;
import eu.busi.myplanning.domain.models.Team;
import eu.busi.myplanning.domain.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Agenda repository.
 */
@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    /**
     * Find agenda by user list.
     *
     * @param user the user
     * @return the list
     */
    List<Agenda> findDistinctByUserOrTeamIsInOrderByByDefaultDescNameAsc(UserEntity user, List<Team> teams);
    List<Agenda> findDistinctBySharedUsersIsInOrSharedTeamsIsInOrderByNameAsc(List<UserEntity> users, List<Team> teams);
}