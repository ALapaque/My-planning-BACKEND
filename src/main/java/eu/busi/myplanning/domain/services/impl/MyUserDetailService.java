package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.domain.models.UserEntity;
import eu.busi.myplanning.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type My user detail service.
 */
@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository _userRepository;

    /**
     * used by the JWT filter in order to find a user from an email or a username
     * @param emailOrUsername
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String emailOrUsername) throws UsernameNotFoundException {
        UserEntity userFound = _userRepository.findByEmailOrUsername(emailOrUsername, emailOrUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new User(userFound.getUsername(), userFound.getPassword(), List.of());
    }
}
