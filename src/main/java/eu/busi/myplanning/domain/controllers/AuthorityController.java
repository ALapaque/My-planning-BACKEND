package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.controllers.AuthorityApi;
import eu.busi.myplanning.api.models.AuthorityDTO;
import eu.busi.myplanning.api.models.Pageable;
import eu.busi.myplanning.domain.services.impl.AuthorityServiceImpl;
import eu.busi.myplanning.exceptions.NotDeletedException;
import eu.busi.myplanning.exceptions.NotFoundException;
import eu.busi.myplanning.exceptions.NotSavedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Authority controller
 * this contains all the endpoints
 */
@RestController
public class AuthorityController implements AuthorityApi {
    private final AuthorityServiceImpl authorityService;

    /**
     * Instantiates a new Authority controller.
     *
     * @param authorityService the authority service
     */
    public AuthorityController(AuthorityServiceImpl authorityService) {
        this.authorityService = authorityService;
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
     * will delete an authority by an id
     */
    @Override
    public ResponseEntity<Boolean> deleteAuthority(Long id) {
        try {
            return new ResponseEntity<>(this.authorityService.deleteById(id), HttpStatus.OK);
        } catch (NotDeletedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * will find an authority by an id
     */
    @Override
    public ResponseEntity<Object> findAuthority(Long id) {
        try {
            Optional<AuthorityDTO> optional = this.authorityService.findById(id);

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
     * Should return a Pageable object with authorities
     * @param pageable
     * @return
     */
    @Override
    public ResponseEntity<Object> listAuthorities(Pageable pageable) {
        try {
            //PageAuthorityDTO page = new PageAuthorityDTO().content(this.authorityService.findAll());

            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (NotFoundException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * will save an authority
     * @param body
     * @return
     */
    @Override
    public ResponseEntity<Object> saveAuthority(AuthorityDTO body) {
        try {
            return new ResponseEntity<>(this.authorityService.save(body), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * will update an authority
     * @param body
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Object> updateAuthority(AuthorityDTO body, Long id) {
        try {
            return new ResponseEntity<>(this.authorityService.update(body, id), HttpStatus.CREATED);
        } catch (NotSavedException e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}