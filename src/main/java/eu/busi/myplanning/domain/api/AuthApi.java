/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.18).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package eu.busi.myplanning.domain.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.domain.dto.JwtAuthenticationRequest;
import eu.busi.myplanning.domain.dto.UserDTO;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-06T09:34:46.153534100+02:00[Europe/Berlin]")
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
