package eu.busi.myplanning.domain.repositories;

import eu.busi.myplanning.domain.models.Card;
import eu.busi.myplanning.domain.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Card repository.
 */
@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    /**
     * Find cards by users list.
     *
     * @param user the user
     * @return the list
     */
    List<Card> findCardsByUsers(UserEntity user);
}