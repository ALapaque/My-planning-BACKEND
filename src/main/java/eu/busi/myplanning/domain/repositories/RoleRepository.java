package eu.busi.myplanning.domain.repositories;

import eu.busi.myplanning.domain.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Role repository.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * Find by name role.
     *
     * @param name the name
     * @return the role
     */
    Role findByName(String name);
}