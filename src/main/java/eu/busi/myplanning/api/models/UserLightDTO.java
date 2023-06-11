package eu.busi.myplanning.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import eu.busi.myplanning.api.models.RoleLightDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserLightDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-11T17:10:17.226883800+02:00[Europe/Paris]")
public class UserLightDTO   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("organization")
  private String organization = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("username")
  private String username = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("role")
  private RoleLightDTO role = null;

  public UserLightDTO id(Long id) {
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

  public UserLightDTO firstName(String firstName) {
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

  public UserLightDTO organization(String organization) {
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

  public UserLightDTO lastName(String lastName) {
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

  public UserLightDTO username(String username) {
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

  public UserLightDTO email(String email) {
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

  public UserLightDTO password(String password) {
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

  public UserLightDTO role(RoleLightDTO role) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserLightDTO userLightDTO = (UserLightDTO) o;
    return Objects.equals(this.id, userLightDTO.id) &&
        Objects.equals(this.firstName, userLightDTO.firstName) &&
        Objects.equals(this.organization, userLightDTO.organization) &&
        Objects.equals(this.lastName, userLightDTO.lastName) &&
        Objects.equals(this.username, userLightDTO.username) &&
        Objects.equals(this.email, userLightDTO.email) &&
        Objects.equals(this.password, userLightDTO.password) &&
        Objects.equals(this.role, userLightDTO.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, organization, lastName, username, email, password, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserLightDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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
