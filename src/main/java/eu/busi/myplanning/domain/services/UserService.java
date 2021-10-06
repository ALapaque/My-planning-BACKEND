package eu.busi.myplanning.domain.services;

import eu.busi.myplanning.api.models.UserDTO;

import java.util.List;
import java.util.Optional;

/**
 * The interface User service.
 */
public interface UserService extends GenericService<UserDTO, Long> {
    /**
     * Find by username or email optional.
     *
     * @param usernameOrEmail the username or email
     * @return the optional
     */
    Optional<UserDTO> findByUsernameOrEmail(String usernameOrEmail);

    /**
     * Find all by organization list.
     *
     * @param organization the organization
     * @return the list
     */
    List<UserDTO> findAllByOrganization(String organization);
}