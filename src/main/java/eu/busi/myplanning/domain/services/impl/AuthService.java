package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.domain.models.Agenda;
import eu.busi.myplanning.domain.models.UserEntity;
import eu.busi.myplanning.domain.repositories.CardRepository;
import eu.busi.myplanning.domain.repositories.RoleRepository;
import eu.busi.myplanning.domain.repositories.UserRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Auth service.
 */
@Service
public class AuthService {
    private final UserRepository _userRepository;
    private final RoleRepository _roleRepository;
    private final CardRepository _cardRepository;

    public AuthService(UserRepository _userRepository, RoleRepository _roleRepository, CardRepository _cardRepository) {
        this._userRepository = _userRepository;
        this._roleRepository = _roleRepository;
        this._cardRepository = _cardRepository;
    }

    /**
     * Login user entity.
     *
     * @param usernameOrEmail the username or email
     * @param password        the password
     * @return the user entity
     */
    public UserEntity login(String usernameOrEmail, String password) {
        return _userRepository.findByEmailOrUsername(usernameOrEmail, usernameOrEmail).orElseThrow(() -> new ResourceNotFoundException("Invalid credentials"));
    }


    public UserEntity register(UserEntity user) {
        if (_userRepository.findByEmailOrUsername(user.getEmail(), user.getUsername()).isPresent()) {
            throw new ResourceNotFoundException("Username or Email already taken");
        }
        user.setRole(_roleRepository.findByName("ADMIN"));
        user.setCards(_cardRepository.findAll());
        Agenda defaultAgenda = Agenda.defaultAgenda();
        defaultAgenda.setUser(user);
        user.setAgendas(List.of(defaultAgenda));

        return _userRepository.save(user);
    }
}
