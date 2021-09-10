/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.18).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package eu.busi.myplanning.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.api.models.Pageable;
import eu.busi.myplanning.api.models.TeamDTO;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-10T10:43:54.248580700+02:00[Europe/Berlin]")
@Api(value = "team", description = "the team API")
public interface TeamApi {

    Logger log = LoggerFactory.getLogger(TeamApi.class);

    Optional<ObjectMapper> getObjectMapper();

    Optional<HttpServletRequest> getRequest();

    

    @ApiOperation(value = "", nickname = "deleteTeam", notes = "", response = Boolean.class, tags={ "Team API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Boolean.class) })
    @RequestMapping(value = "/team/{id}",
        produces = { "*/*" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Boolean> deleteTeam(@ApiParam(value = "",required=true) @PathVariable("id") Long id
);


    @ApiOperation(value = "", nickname = "findTeam", notes = "", response = Object.class, tags={ "Team API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Object.class) })
    @RequestMapping(value = "/team/{id}",
        produces = { "*/*" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> findTeam(@ApiParam(value = "",required=true) @PathVariable("id") Long id
);


    @ApiOperation(value = "", nickname = "listTeams", notes = "", response = Object.class, tags={ "Team API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Object.class) })
    @RequestMapping(value = "/team",
        produces = { "*/*" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> listTeams(@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "pageable", required = true) Pageable pageable
);


    @ApiOperation(value = "", nickname = "saveTeam", notes = "", response = Object.class, tags={ "Team API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = Object.class) })
    @RequestMapping(value = "/team",
        produces = { "*/*" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Object> saveTeam(@ApiParam(value = "" ,required=true )  @Valid @RequestBody TeamDTO body
);


    @ApiOperation(value = "", nickname = "updateTeam", notes = "", response = Object.class, tags={ "Team API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Object.class) })
    @RequestMapping(value = "/team/{id}",
        produces = { "*/*" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Object> updateTeam(@ApiParam(value = "" ,required=true )  @Valid @RequestBody TeamDTO body
,@ApiParam(value = "",required=true) @PathVariable("id") Long id
);

}