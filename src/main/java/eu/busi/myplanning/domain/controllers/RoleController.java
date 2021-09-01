package eu.busi.myplanning.domain.controllers;

import eu.busi.myplanning.api.RoleApi;
import eu.busi.myplanning.models.PageRoleDTO;
import eu.busi.myplanning.models.Pageable;
import eu.busi.myplanning.models.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RoleController implements RoleApi {
    @Override
    public ResponseEntity<Void> deleteRole(Long id) {
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