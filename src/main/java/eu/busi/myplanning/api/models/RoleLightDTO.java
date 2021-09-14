package eu.busi.myplanning.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * RoleLightDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T11:20:33.931268100+02:00[Europe/Berlin]")
public class RoleLightDTO   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("authorities")
  @Valid
  private List<AuthorityLightDTO> authorities = null;

  public RoleLightDTO id(Long id) {
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

  public RoleLightDTO name(String name) {
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

  public RoleLightDTO authorities(List<AuthorityLightDTO> authorities) {
    this.authorities = authorities;
    return this;
  }

  public RoleLightDTO addAuthoritiesItem(AuthorityLightDTO authoritiesItem) {
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
    RoleLightDTO roleLightDTO = (RoleLightDTO) o;
    return Objects.equals(this.id, roleLightDTO.id) &&
        Objects.equals(this.name, roleLightDTO.name) &&
        Objects.equals(this.authorities, roleLightDTO.authorities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, authorities);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoleLightDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
