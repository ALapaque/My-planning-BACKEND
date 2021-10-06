package eu.busi.myplanning.domain.repositories;

import eu.busi.myplanning.domain.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    /**
     * Find all by organization order by first name asc list.
     *
     * @param organization the organization
     * @return the list
     */
    List<UserEntity> findAllByOrganizationOrderByFirstNameAsc(String organization);

    /**
     * Find all by order by first name asc list.
     *
     * @return the list
     */
    List<UserEntity> findAllByOrderByFirstNameAsc();

    /**
     * Find by email or username optional.
     *
     * @param email    the email
     * @param username the username
     * @return the optional
     */
    Optional<UserEntity> findByEmailOrUsername(String email, String username);

    /**
     * Find by username optional.
     *
     * @param username the username
     * @return the optional
     */
    Optional<UserEntity> findByUsername(String username);
}