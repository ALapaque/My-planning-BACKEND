package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.AuthorityApi;
import eu.busi.myplanning.models.AuthorityDTO;
import eu.busi.myplanning.models.PageAuthorityDTO;
import eu.busi.myplanning.models.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class AuthorityController implements AuthorityApi {
    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Void> deleteAuthority(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<AuthorityDTO> findAuthority(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<PageAuthorityDTO> listAuthorities(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<AuthorityDTO> saveAuthority(AuthorityDTO body) {
        return null;
    }

    @Override
    public ResponseEntity<AuthorityDTO> updateAuthority(AuthorityDTO body, Long id) {
        return null;
    }
}