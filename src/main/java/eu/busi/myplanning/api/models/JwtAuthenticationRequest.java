package eu.busi.myplanning.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * JwtAuthenticationRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-11T17:10:17.226883800+02:00[Europe/Paris]")
public class JwtAuthenticationRequest   {
  @JsonProperty("usernameOrEmail")
  private String usernameOrEmail = null;

  @JsonProperty("password")
  private String password = null;

  public JwtAuthenticationRequest usernameOrEmail(String usernameOrEmail) {
    this.usernameOrEmail = usernameOrEmail;
    return this;
  }

  /**
   * Get usernameOrEmail
   * @return usernameOrEmail
  **/
  @ApiModelProperty(value = "")
  
    public String getUsernameOrEmail() {
    return usernameOrEmail;
  }

  public void setUsernameOrEmail(String usernameOrEmail) {
    this.usernameOrEmail = usernameOrEmail;
  }

  public JwtAuthenticationRequest password(String password) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JwtAuthenticationRequest jwtAuthenticationRequest = (JwtAuthenticationRequest) o;
    return Objects.equals(this.usernameOrEmail, jwtAuthenticationRequest.usernameOrEmail) &&
        Objects.equals(this.password, jwtAuthenticationRequest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(usernameOrEmail, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JwtAuthenticationRequest {\n");
    
    sb.append("    usernameOrEmail: ").append(toIndentedString(usernameOrEmail)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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
