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
 * AgendaLightDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-11T09:18:24.321227300+02:00[Europe/Paris]")
public class AgendaLightDTO   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("byDefault")
  private Boolean byDefault = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("color")
  private String color = null;

  public AgendaLightDTO id(Long id) {
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

  public AgendaLightDTO byDefault(Boolean byDefault) {
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

  public AgendaLightDTO name(String name) {
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

  public AgendaLightDTO color(String color) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AgendaLightDTO agendaLightDTO = (AgendaLightDTO) o;
    return Objects.equals(this.id, agendaLightDTO.id) &&
        Objects.equals(this.byDefault, agendaLightDTO.byDefault) &&
        Objects.equals(this.name, agendaLightDTO.name) &&
        Objects.equals(this.color, agendaLightDTO.color);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, byDefault, name, color);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgendaLightDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    byDefault: ").append(toIndentedString(byDefault)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
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
