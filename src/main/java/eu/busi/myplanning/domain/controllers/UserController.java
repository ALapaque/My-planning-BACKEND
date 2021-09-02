package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.UserApi;
import eu.busi.myplanning.models.PageUserDTO;
import eu.busi.myplanning.models.Pageable;
import eu.busi.myplanning.models.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * The type User controller.
 */
@RestController
public class UserController implements UserApi {

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Boolean> deleteUser(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<UserDTO> findUser(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<PageUserDTO> listUsers(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<UserDTO> saveUser(UserDTO body) {
        return null;
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(UserDTO body, Long id) {
        return null;
    }
}