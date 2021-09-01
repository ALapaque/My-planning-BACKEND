package eu.busi.myplanning.domain.controllers;

import eu.busi.myplanning.api.UserApi;
import eu.busi.myplanning.models.PageUserDTO;
import eu.busi.myplanning.models.Pageable;
import eu.busi.myplanning.models.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type User controller.
 */
@RestController
public class UserController implements UserApi {

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