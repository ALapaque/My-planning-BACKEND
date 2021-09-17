package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.domain.models.UserEntity;
import eu.busi.myplanning.domain.repositories.RoleRepository;
import eu.busi.myplanning.domain.repositories.UserRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

/**
 * The type Auth service.
 */
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final UserServiceImpl userService;
    private final RoleRepository roleRepository;

    public AuthService(UserRepository userRepository, UserServiceImpl userService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    /**
     * Login user entity.
     *
     * @param usernameOrEmail the username or email
     * @param password        the password
     * @return the user entity
     */
    public UserEntity login(String usernameOrEmail, String password) {
        return userRepository.findByEmailOrUsername(usernameOrEmail, usernameOrEmail).orElseThrow(() -> new ResourceNotFoundException("Invalid credentials"));
    }


    public UserEntity register(UserEntity user) {
        if (userRepository.findByEmailOrUsername(user.getEmail(), user.getUsername()).isPresent()) {
            throw new ResourceNotFoundException("Username or Email already taken");
        }
        user = this.userService.initDefaultUser(user);
        user.setRole(roleRepository.findByName("ADMIN"));

        return userRepository.save(user);
    }
}
