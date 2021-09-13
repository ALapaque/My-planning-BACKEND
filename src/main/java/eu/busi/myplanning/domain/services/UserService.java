package eu.busi.myplanning.domain.services;

import eu.busi.myplanning.api.models.UserDTO;

import java.util.Optional;

/**
 * The interface User service.
 */
public interface UserService extends GenericService<UserDTO, Long> {
    Optional<UserDTO> findByUsernameOrEmail(String usernameOrEmail);
}