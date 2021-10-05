package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.controllers.RoleApi;
import eu.busi.myplanning.api.models.RoleDTO;
import eu.busi.myplanning.domain.services.impl.RoleServiceImpl;
import eu.busi.myplanning.exceptions.NotDeletedException;
import eu.busi.myplanning.exceptions.NotFoundException;
import eu.busi.myplanning.exceptions.NotSavedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Role controller
 * this contains all the endpoints
 */
@RestController
public class RoleController implements RoleApi {
    private final RoleServiceImpl roleService;

    /**
     * Instantiates a new Role controller.
     *
     * @param roleService the role service
     */
    public RoleController(RoleServiceImpl roleService) {
        this.roleService = roleService;
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
     * delete a role by an id
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Boolean> deleteRole(Long id) {
        try {
            return new ResponseEntity<>(this.roleService.deleteById(id), HttpStatus.OK);
        } catch (NotDeletedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * find a role by an id
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Object> findRole(Long id) {
        try {
            Optional<RoleDTO> optional = this.roleService.findById(id);

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
     * find all roles
     * @return
     */
    @Override
    public ResponseEntity<Object> findRoles() {
        try {
            return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
        } catch (NotFoundException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * save a role
     * @param body
     * @return
     */
    @Override
    public ResponseEntity<Object> saveRole(RoleDTO body) {
        try {
            return new ResponseEntity<>(this.roleService.save(body), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * update a role
     * @param body
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Object> updateRole(RoleDTO body, Long id) {
        try {
            return new ResponseEntity<>(this.roleService.update(body, id), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}