package eu.busi.myplanning.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.RoleApi;
import eu.busi.myplanning.models.PageRoleDTO;
import eu.busi.myplanning.models.Pageable;
import eu.busi.myplanning.models.RoleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class RoleController implements RoleApi {
    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Boolean> deleteRole(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<RoleDTO> findRole(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<PageRoleDTO> listRoles(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<RoleDTO> saveRole(RoleDTO body) {
        return null;
    }

    @Override
    public ResponseEntity<RoleDTO> updateRole(RoleDTO body, Long id) {
        return null;
    }
}