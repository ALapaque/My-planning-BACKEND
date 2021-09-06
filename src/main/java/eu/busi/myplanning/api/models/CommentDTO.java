package eu.busi.myplanning.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Objects;

/**
 * CommentDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-06T09:55:51.442971500+02:00[Europe/Berlin]")
public class CommentDTO   {
  @JsonProperty("createdAt")
  private Instant createdAt = null;

  @JsonProperty("updatedAt")
  private Instant updatedAt = null;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("content")
  private String content = null;

  @JsonProperty("user")
  private UserLightDTO user = null;

  @JsonProperty("event")
  private EventLightDTO event = null;

  public CommentDTO createdAt(Instant createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public CommentDTO updatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Get updatedAt
   * @return updatedAt
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public CommentDTO id(Long id) {
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

  public CommentDTO content(String content) {
    this.content = content;
    return this;
  }

  /**
   * Get content
   * @return content
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public CommentDTO user(UserLightDTO user) {
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

  public CommentDTO event(EventLightDTO event) {
    this.event = event;
    return this;
  }

  /**
   * Get event
   * @return event
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public EventLightDTO getEvent() {
    return event;
  }

  public void setEvent(EventLightDTO event) {
    this.event = event;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommentDTO commentDTO = (CommentDTO) o;
    return Objects.equals(this.createdAt, commentDTO.createdAt) &&
        Objects.equals(this.updatedAt, commentDTO.updatedAt) &&
        Objects.equals(this.id, commentDTO.id) &&
        Objects.equals(this.content, commentDTO.content) &&
        Objects.equals(this.user, commentDTO.user) &&
        Objects.equals(this.event, commentDTO.event);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdAt, updatedAt, id, content, user, event);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentDTO {\n");
    
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
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
