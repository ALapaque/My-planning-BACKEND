package eu.busi.myplanning.domain.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import eu.busi.myplanning.domain.dto.AuthorityLightDTO;
import eu.busi.myplanning.domain.dto.UserLightDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RoleDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-03T19:48:41.441946+02:00[Europe/Paris]")
public class RoleDTO   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("users")
  @Valid
  private List<UserLightDTO> users = null;

  @JsonProperty("authorities")
  @Valid
  private List<AuthorityLightDTO> authorities = null;

  public RoleDTO id(Long id) {
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

  public RoleDTO name(String name) {
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

  public RoleDTO users(List<UserLightDTO> users) {
    this.users = users;
    return this;
  }

  public RoleDTO addUsersItem(UserLightDTO usersItem) {
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

  public RoleDTO authorities(List<AuthorityLightDTO> authorities) {
    this.authorities = authorities;
    return this;
  }

  public RoleDTO addAuthoritiesItem(AuthorityLightDTO authoritiesItem) {
    if (this.authorities == null) {
      this.authorities = new ArrayList<>();
    }
    this.authorities.add(authoritiesItem);
    return this;
  }

  /**
   * Get authorities
   * @return authorities
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<AuthorityLightDTO> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(List<AuthorityLightDTO> authorities) {
    this.authorities = authorities;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoleDTO roleDTO = (RoleDTO) o;
    return Objects.equals(this.id, roleDTO.id) &&
        Objects.equals(this.name, roleDTO.name) &&
        Objects.equals(this.users, roleDTO.users) &&
        Objects.equals(this.authorities, roleDTO.authorities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, users, authorities);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoleDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("    authorities: ").append(toIndentedString(authorities)).append("\n");
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
