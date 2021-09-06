/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.18).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package eu.busi.myplanning.domain.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.busi.myplanning.domain.dto.CardDTO;
import eu.busi.myplanning.domain.dto.CardType;
import eu.busi.myplanning.domain.dto.Pageable;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-06T09:34:46.153534100+02:00[Europe/Berlin]")
@Api(value = "card", description = "the card API")
public interface CardApi {

    Logger log = LoggerFactory.getLogger(CardApi.class);

    Optional<ObjectMapper> getObjectMapper();

    Optional<HttpServletRequest> getRequest();

    

    @ApiOperation(value = "", nickname = "deleteCard", notes = "", response = Boolean.class, tags={ "Card API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Boolean.class) })
    @RequestMapping(value = "/card/{id}",
        produces = { "*/*" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Boolean> deleteCard(@ApiParam(value = "",required=true) @PathVariable("id") Long id
);


    @ApiOperation(value = "", nickname = "findCard", notes = "", response = Object.class, tags={ "Card API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Object.class) })
    @RequestMapping(value = "/card/{id}",
        produces = { "*/*" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> findCard(@ApiParam(value = "",required=true) @PathVariable("id") Long id
);


    @ApiOperation(value = "", nickname = "findCardContent", notes = "", response = Object.class, tags={ "Card API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Object.class) })
    @RequestMapping(value = "/card/incoming",
        produces = { "*/*" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> findCardContent(@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "userId", required = true) Long userId
,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "type", required = true) CardType type
,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "start", required = true) Instant start
,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "end", required = true) Instant end
);


    @ApiOperation(value = "", nickname = "findCardsByUser", notes = "", response = Object.class, tags={ "Card API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Object.class) })
    @RequestMapping(value = "/card/user/{id}",
        produces = { "*/*" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> findCardsByUser(@ApiParam(value = "",required=true) @PathVariable("id") Long id
);


    @ApiOperation(value = "", nickname = "listCards", notes = "", response = Object.class, tags={ "Card API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Object.class) })
    @RequestMapping(value = "/card",
        produces = { "*/*" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> listCards(@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "pageable", required = true) Pageable pageable
);


    @ApiOperation(value = "", nickname = "saveCard", notes = "", response = Object.class, tags={ "Card API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = Object.class) })
    @RequestMapping(value = "/card",
        produces = { "*/*" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Object> saveCard(@ApiParam(value = "" ,required=true )  @Valid @RequestBody CardDTO body
);


    @ApiOperation(value = "", nickname = "updateCard", notes = "", response = Object.class, tags={ "Card API", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Object.class) })
    @RequestMapping(value = "/card/{id}",
        produces = { "*/*" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Object> updateCard(@ApiParam(value = "" ,required=true )  @Valid @RequestBody CardDTO body
,@ApiParam(value = "",required=true) @PathVariable("id") Long id
);

}
