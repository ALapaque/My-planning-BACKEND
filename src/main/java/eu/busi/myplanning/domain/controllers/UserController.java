package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.controllers.UserApi;
import eu.busi.myplanning.api.models.UserDTO;
import eu.busi.myplanning.domain.services.impl.UserServiceImpl;
import eu.busi.myplanning.exceptions.NotDeletedException;
import eu.busi.myplanning.exceptions.NotFoundException;
import eu.busi.myplanning.exceptions.NotSavedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * User controller
 * contains all the endpoints
 */
@RestController
public class UserController implements UserApi {
    private final UserServiceImpl userService;

    /**
     * Instantiates a new User controller.
     *
     * @param userService the user service
     */
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * will delete a user by an id
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Boolean> deleteUser(Long id) {
        try {
            return new ResponseEntity<>(this.userService.deleteById(id), HttpStatus.OK);
        } catch (NotDeletedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * will find a user by an id or an email
     * @param idOrUsernameOrEmail
     * @return
     */
    @Override
    public ResponseEntity<Object> findUser(String idOrUsernameOrEmail) {
        try {
            Optional<UserDTO> optional;

            try {
                Long id = Long.parseLong(idOrUsernameOrEmail);
                optional = this.userService.findById(id);
            } catch (NumberFormatException e) {
                optional = this.userService.findByUsernameOrEmail(idOrUsernameOrEmail);
            }

            if (optional.isPresent()) {
                return new ResponseEntity<>(optional.get(), HttpStatus.OK);
            } else {
                throw new NotFoundException();
            }
        } catch (NotFoundException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * will find users by an organization
     * @param organization
     * @return
     */
    @Override
    public ResponseEntity<Object> findUsersByOrganization(String organization) {
        try {
            return new ResponseEntity<>(this.userService.findAllByOrganization(organization), HttpStatus.OK);
        } catch (NotFoundException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * will save a user
     * @param body
     * @return
     */
    @Override
    public ResponseEntity<Object> saveUser(UserDTO body) {
        try {
            return new ResponseEntity<>(this.userService.save(body), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * will update the user
     * @param body
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Object> updateUser(UserDTO body, Long id) {
        try {
            return new ResponseEntity<>(this.userService.update(body, id), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}