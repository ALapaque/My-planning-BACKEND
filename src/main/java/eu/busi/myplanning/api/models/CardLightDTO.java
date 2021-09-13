package eu.busi.myplanning.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * CardLightDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-13T17:42:56.959298800+02:00[Europe/Berlin]")
public class CardLightDTO   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("recap")
  private Boolean recap = null;

  @JsonProperty("type")
  private CardType type = null;

  @JsonProperty("size")
  private CardSize size = null;

  public CardLightDTO id(Long id) {
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

  public CardLightDTO recap(Boolean recap) {
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

  public CardLightDTO type(CardType type) {
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

  public CardLightDTO size(CardSize size) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardLightDTO cardLightDTO = (CardLightDTO) o;
    return Objects.equals(this.id, cardLightDTO.id) &&
        Objects.equals(this.recap, cardLightDTO.recap) &&
        Objects.equals(this.type, cardLightDTO.type) &&
        Objects.equals(this.size, cardLightDTO.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, recap, type, size);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardLightDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    recap: ").append(toIndentedString(recap)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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
