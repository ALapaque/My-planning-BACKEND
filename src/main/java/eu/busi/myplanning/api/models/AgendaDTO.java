package eu.busi.myplanning.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import eu.busi.myplanning.api.models.EventLightDTO;
import eu.busi.myplanning.api.models.TeamLightDTO;
import eu.busi.myplanning.api.models.UserLightDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AgendaDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-11T17:10:17.226883800+02:00[Europe/Paris]")
public class AgendaDTO   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("byDefault")
  private Boolean byDefault = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("color")
  private String color = null;

  @JsonProperty("user")
  private UserLightDTO user = null;

  @JsonProperty("team")
  private TeamLightDTO team = null;

  @JsonProperty("events")
  @Valid
  private List<EventLightDTO> events = null;

  @JsonProperty("sharedEvents")
  @Valid
  private List<EventLightDTO> sharedEvents = null;

  @JsonProperty("sharedUsers")
  @Valid
  private List<UserLightDTO> sharedUsers = null;

  @JsonProperty("sharedTeams")
  @Valid
  private List<TeamLightDTO> sharedTeams = null;

  public AgendaDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  
    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public AgendaDTO byDefault(Boolean byDefault) {
    this.byDefault = byDefault;
    return this;
  }

  /**
   * Get byDefault
   * @return byDefault
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isByDefault() {
    return byDefault;
  }

  public void setByDefault(Boolean byDefault) {
    this.byDefault = byDefault;
  }

  public AgendaDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AgendaDTO color(String color) {
    this.color = color;
    return this;
  }

  /**
   * Get color
   * @return color
  **/
  @ApiModelProperty(value = "")
  
    public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public AgendaDTO user(UserLightDTO user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public UserLightDTO getUser() {
    return user;
  }

  public void setUser(UserLightDTO user) {
    this.user = user;
  }

  public AgendaDTO team(TeamLightDTO team) {
    this.team = team;
    return this;
  }

  /**
   * Get team
   * @return team
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public TeamLightDTO getTeam() {
    return team;
  }

  public void setTeam(TeamLightDTO team) {
    this.team = team;
  }

  public AgendaDTO events(List<EventLightDTO> events) {
    this.events = events;
    return this;
  }

  public AgendaDTO addEventsItem(EventLightDTO eventsItem) {
    if (this.events == null) {
      this.events = new ArrayList<>();
    }
    this.events.add(eventsItem);
    return this;
  }

  /**
   * Get events
   * @return events
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<EventLightDTO> getEvents() {
    return events;
  }

  public void setEvents(List<EventLightDTO> events) {
    this.events = events;
  }

  public AgendaDTO sharedEvents(List<EventLightDTO> sharedEvents) {
    this.sharedEvents = sharedEvents;
    return this;
  }

  public AgendaDTO addSharedEventsItem(EventLightDTO sharedEventsItem) {
    if (this.sharedEvents == null) {
      this.sharedEvents = new ArrayList<>();
    }
    this.sharedEvents.add(sharedEventsItem);
    return this;
  }

  /**
   * Get sharedEvents
   * @return sharedEvents
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<EventLightDTO> getSharedEvents() {
    return sharedEvents;
  }

  public void setSharedEvents(List<EventLightDTO> sharedEvents) {
    this.sharedEvents = sharedEvents;
  }

  public AgendaDTO sharedUsers(List<UserLightDTO> sharedUsers) {
    this.sharedUsers = sharedUsers;
    return this;
  }

  public AgendaDTO addSharedUsersItem(UserLightDTO sharedUsersItem) {
    if (this.sharedUsers == null) {
      this.sharedUsers = new ArrayList<>();
    }
    this.sharedUsers.add(sharedUsersItem);
    return this;
  }

  /**
   * Get sharedUsers
   * @return sharedUsers
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<UserLightDTO> getSharedUsers() {
    return sharedUsers;
  }

  public void setSharedUsers(List<UserLightDTO> sharedUsers) {
    this.sharedUsers = sharedUsers;
  }

  public AgendaDTO sharedTeams(List<TeamLightDTO> sharedTeams) {
    this.sharedTeams = sharedTeams;
    return this;
  }

  public AgendaDTO addSharedTeamsItem(TeamLightDTO sharedTeamsItem) {
    if (this.sharedTeams == null) {
      this.sharedTeams = new ArrayList<>();
    }
    this.sharedTeams.add(sharedTeamsItem);
    return this;
  }

  /**
   * Get sharedTeams
   * @return sharedTeams
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<TeamLightDTO> getSharedTeams() {
    return sharedTeams;
  }

  public void setSharedTeams(List<TeamLightDTO> sharedTeams) {
    this.sharedTeams = sharedTeams;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AgendaDTO agendaDTO = (AgendaDTO) o;
    return Objects.equals(this.id, agendaDTO.id) &&
        Objects.equals(this.byDefault, agendaDTO.byDefault) &&
        Objects.equals(this.name, agendaDTO.name) &&
        Objects.equals(this.color, agendaDTO.color) &&
        Objects.equals(this.user, agendaDTO.user) &&
        Objects.equals(this.team, agendaDTO.team) &&
        Objects.equals(this.events, agendaDTO.events) &&
        Objects.equals(this.sharedEvents, agendaDTO.sharedEvents) &&
        Objects.equals(this.sharedUsers, agendaDTO.sharedUsers) &&
        Objects.equals(this.sharedTeams, agendaDTO.sharedTeams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, byDefault, name, color, user, team, events, sharedEvents, sharedUsers, sharedTeams);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgendaDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    byDefault: ").append(toIndentedString(byDefault)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    team: ").append(toIndentedString(team)).append("\n");
    sb.append("    events: ").append(toIndentedString(events)).append("\n");
    sb.append("    sharedEvents: ").append(toIndentedString(sharedEvents)).append("\n");
    sb.append("    sharedUsers: ").append(toIndentedString(sharedUsers)).append("\n");
    sb.append("    sharedTeams: ").append(toIndentedString(sharedTeams)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
