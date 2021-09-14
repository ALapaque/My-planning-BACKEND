package eu.busi.myplanning.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import eu.busi.myplanning.api.models.AgendaLightDTO;
import eu.busi.myplanning.api.models.UserLightDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TeamDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T21:59:49.960608700+02:00[Europe/Paris]")
public class TeamDTO   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("users")
  @Valid
  private List<UserLightDTO> users = null;

  @JsonProperty("agendas")
  @Valid
  private List<AgendaLightDTO> agendas = null;

  @JsonProperty("sharedAgendas")
  @Valid
  private List<AgendaLightDTO> sharedAgendas = null;

  public TeamDTO id(Long id) {
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

  public TeamDTO name(String name) {
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

  public TeamDTO users(List<UserLightDTO> users) {
    this.users = users;
    return this;
  }

  public TeamDTO addUsersItem(UserLightDTO usersItem) {
    if (this.users == null) {
      this.users = new ArrayList<>();
    }
    this.users.add(usersItem);
    return this;
  }

  /**
   * Get users
   * @return users
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<UserLightDTO> getUsers() {
    return users;
  }

  public void setUsers(List<UserLightDTO> users) {
    this.users = users;
  }

  public TeamDTO agendas(List<AgendaLightDTO> agendas) {
    this.agendas = agendas;
    return this;
  }

  public TeamDTO addAgendasItem(AgendaLightDTO agendasItem) {
    if (this.agendas == null) {
      this.agendas = new ArrayList<>();
    }
    this.agendas.add(agendasItem);
    return this;
  }

  /**
   * Get agendas
   * @return agendas
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<AgendaLightDTO> getAgendas() {
    return agendas;
  }

  public void setAgendas(List<AgendaLightDTO> agendas) {
    this.agendas = agendas;
  }

  public TeamDTO sharedAgendas(List<AgendaLightDTO> sharedAgendas) {
    this.sharedAgendas = sharedAgendas;
    return this;
  }

  public TeamDTO addSharedAgendasItem(AgendaLightDTO sharedAgendasItem) {
    if (this.sharedAgendas == null) {
      this.sharedAgendas = new ArrayList<>();
    }
    this.sharedAgendas.add(sharedAgendasItem);
    return this;
  }

  /**
   * Get sharedAgendas
   * @return sharedAgendas
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<AgendaLightDTO> getSharedAgendas() {
    return sharedAgendas;
  }

  public void setSharedAgendas(List<AgendaLightDTO> sharedAgendas) {
    this.sharedAgendas = sharedAgendas;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TeamDTO teamDTO = (TeamDTO) o;
    return Objects.equals(this.id, teamDTO.id) &&
        Objects.equals(this.name, teamDTO.name) &&
        Objects.equals(this.users, teamDTO.users) &&
        Objects.equals(this.agendas, teamDTO.agendas) &&
        Objects.equals(this.sharedAgendas, teamDTO.sharedAgendas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, users, agendas, sharedAgendas);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TeamDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("    agendas: ").append(toIndentedString(agendas)).append("\n");
    sb.append("    sharedAgendas: ").append(toIndentedString(sharedAgendas)).append("\n");
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
