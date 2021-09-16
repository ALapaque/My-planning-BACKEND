package eu.busi.myplanning.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * UserDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-16T17:35:03.693542400+02:00[Europe/Berlin]")
public class UserDTO   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("organization")
  private String organization = null;

  @JsonProperty("username")
  private String username = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("role")
  private RoleLightDTO role = null;

  @JsonProperty("comments")
  @Valid
  private List<CommentLightDTO> comments = null;

  @JsonProperty("agendas")
  @Valid
  private List<AgendaDTO> agendas = null;

  @JsonProperty("teams")
  @Valid
  private List<TeamLightDTO> teams = null;

  @JsonProperty("cards")
  @Valid
  private List<CardLightDTO> cards = null;

  @JsonProperty("sharedAgendas")
  @Valid
  private List<AgendaDTO> sharedAgendas = null;

  public UserDTO id(Long id) {
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

  public UserDTO firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  **/
  @ApiModelProperty(value = "")
  
    public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserDTO lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  **/
  @ApiModelProperty(value = "")
  
    public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserDTO organization(String organization) {
    this.organization = organization;
    return this;
  }

  /**
   * Get organization
   * @return organization
  **/
  @ApiModelProperty(value = "")
  
    public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public UserDTO username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
  **/
  @ApiModelProperty(value = "")
  
    public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UserDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")
  
    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserDTO password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  **/
  @ApiModelProperty(value = "")
  
    public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserDTO role(RoleLightDTO role) {
    this.role = role;
    return this;
  }

  /**
   * Get role
   * @return role
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public RoleLightDTO getRole() {
    return role;
  }

  public void setRole(RoleLightDTO role) {
    this.role = role;
  }

  public UserDTO comments(List<CommentLightDTO> comments) {
    this.comments = comments;
    return this;
  }

  public UserDTO addCommentsItem(CommentLightDTO commentsItem) {
    if (this.comments == null) {
      this.comments = new ArrayList<>();
    }
    this.comments.add(commentsItem);
    return this;
  }

  /**
   * Get comments
   * @return comments
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<CommentLightDTO> getComments() {
    return comments;
  }

  public void setComments(List<CommentLightDTO> comments) {
    this.comments = comments;
  }

  public UserDTO agendas(List<AgendaDTO> agendas) {
    this.agendas = agendas;
    return this;
  }

  public UserDTO addAgendasItem(AgendaDTO agendasItem) {
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
    public List<AgendaDTO> getAgendas() {
    return agendas;
  }

  public void setAgendas(List<AgendaDTO> agendas) {
    this.agendas = agendas;
  }

  public UserDTO teams(List<TeamLightDTO> teams) {
    this.teams = teams;
    return this;
  }

  public UserDTO addTeamsItem(TeamLightDTO teamsItem) {
    if (this.teams == null) {
      this.teams = new ArrayList<>();
    }
    this.teams.add(teamsItem);
    return this;
  }

  /**
   * Get teams
   * @return teams
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<TeamLightDTO> getTeams() {
    return teams;
  }

  public void setTeams(List<TeamLightDTO> teams) {
    this.teams = teams;
  }

  public UserDTO cards(List<CardLightDTO> cards) {
    this.cards = cards;
    return this;
  }

  public UserDTO addCardsItem(CardLightDTO cardsItem) {
    if (this.cards == null) {
      this.cards = new ArrayList<>();
    }
    this.cards.add(cardsItem);
    return this;
  }

  /**
   * Get cards
   * @return cards
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<CardLightDTO> getCards() {
    return cards;
  }

  public void setCards(List<CardLightDTO> cards) {
    this.cards = cards;
  }

  public UserDTO sharedAgendas(List<AgendaDTO> sharedAgendas) {
    this.sharedAgendas = sharedAgendas;
    return this;
  }

  public UserDTO addSharedAgendasItem(AgendaDTO sharedAgendasItem) {
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
    public List<AgendaDTO> getSharedAgendas() {
    return sharedAgendas;
  }

  public void setSharedAgendas(List<AgendaDTO> sharedAgendas) {
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
    UserDTO userDTO = (UserDTO) o;
    return Objects.equals(this.id, userDTO.id) &&
        Objects.equals(this.firstName, userDTO.firstName) &&
        Objects.equals(this.lastName, userDTO.lastName) &&
        Objects.equals(this.organization, userDTO.organization) &&
        Objects.equals(this.username, userDTO.username) &&
        Objects.equals(this.email, userDTO.email) &&
        Objects.equals(this.password, userDTO.password) &&
        Objects.equals(this.role, userDTO.role) &&
        Objects.equals(this.comments, userDTO.comments) &&
        Objects.equals(this.agendas, userDTO.agendas) &&
        Objects.equals(this.teams, userDTO.teams) &&
        Objects.equals(this.cards, userDTO.cards) &&
        Objects.equals(this.sharedAgendas, userDTO.sharedAgendas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, organization, username, email, password, role, comments, agendas, teams, cards, sharedAgendas);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
    sb.append("    agendas: ").append(toIndentedString(agendas)).append("\n");
    sb.append("    teams: ").append(toIndentedString(teams)).append("\n");
    sb.append("    cards: ").append(toIndentedString(cards)).append("\n");
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
