package eu.busi.myplanning.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CardDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-16T17:35:03.693542400+02:00[Europe/Berlin]")
public class CardDTO   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("recap")
  private Boolean recap = null;

  @JsonProperty("type")
  private CardType type = null;

  @JsonProperty("size")
  private CardSize size = null;

  @JsonProperty("users")
  @Valid
  private List<UserLightDTO> users = null;

  public CardDTO id(Long id) {
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

  public CardDTO recap(Boolean recap) {
    this.recap = recap;
    return this;
  }

  /**
   * Get recap
   * @return recap
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isRecap() {
    return recap;
  }

  public void setRecap(Boolean recap) {
    this.recap = recap;
  }

  public CardDTO type(CardType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public CardType getType() {
    return type;
  }

  public void setType(CardType type) {
    this.type = type;
  }

  public CardDTO size(CardSize size) {
    this.size = size;
    return this;
  }

  /**
   * Get size
   * @return size
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public CardSize getSize() {
    return size;
  }

  public void setSize(CardSize size) {
    this.size = size;
  }

  public CardDTO users(List<UserLightDTO> users) {
    this.users = users;
    return this;
  }

  public CardDTO addUsersItem(UserLightDTO usersItem) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardDTO cardDTO = (CardDTO) o;
    return Objects.equals(this.id, cardDTO.id) &&
        Objects.equals(this.recap, cardDTO.recap) &&
        Objects.equals(this.type, cardDTO.type) &&
        Objects.equals(this.size, cardDTO.size) &&
        Objects.equals(this.users, cardDTO.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, recap, type, size, users);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    recap: ").append(toIndentedString(recap)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
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
