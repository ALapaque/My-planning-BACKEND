/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.18).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package eu.busi.myplanning.api.controllers;

import eu.busi.myplanning.api.models.JwtAuthenticationRequest;
import eu.busi.myplanning.api.models.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T21:59:49.960608700+02:00[Europe/Paris]")
@Api(value = "auth", description = "the auth API")
public interface AuthApi {

    Logger log = LoggerFactory.getLogger(AuthApi.class);

    Optional<ObjectMapper> getObjectMapper();

    Optional<HttpServletRequest> getRequest();

    

    @ApiOperation(value = "", nickname = "authenticateUser", notes = "", response = Object.class, tags={ "Auth API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Object.class) })
    @RequestMapping(value = "/auth/login",
        produces = { "*/*" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Object> authenticateUser(@ApiParam(value = "" ,required=true )  @Valid @RequestBody JwtAuthenticationRequest body
);


    @ApiOperation(value = "", nickname = "register", notes = "", response = Object.class, tags={ "Auth API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Object.class) })
    @RequestMapping(value = "/auth/register",
        produces = { "*/*" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Object> register(@ApiParam(value = "" ,required=true )  @Valid @RequestBody UserDTO body
);

}
