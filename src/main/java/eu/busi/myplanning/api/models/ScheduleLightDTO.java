package eu.busi.myplanning.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.sql.Time;
import java.util.Objects;

/**
 * ScheduleLightDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-16T17:35:03.693542400+02:00[Europe/Berlin]")
public class ScheduleLightDTO   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("day")
  private Integer day = null;

  @JsonProperty("startHour")
  private Time startHour = null;

  @JsonProperty("endHour")
  private Time endHour = null;

  @JsonProperty("hasBreak")
  private Boolean hasBreak = null;

  @JsonProperty("startBreak")
  private Time startBreak = null;

  @JsonProperty("endBreak")
  private Time endBreak = null;

  public ScheduleLightDTO id(Long id) {
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

  public ScheduleLightDTO day(Integer day) {
    this.day = day;
    return this;
  }

  /**
   * Get day
   * @return day
  **/
  @ApiModelProperty(value = "")
  
    public Integer getDay() {
    return day;
  }

  public void setDay(Integer day) {
    this.day = day;
  }

  public ScheduleLightDTO startHour(Time startHour) {
    this.startHour = startHour;
    return this;
  }

  /**
   * Get startHour
   * @return startHour
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Time getStartHour() {
    return startHour;
  }

  public void setStartHour(Time startHour) {
    this.startHour = startHour;
  }

  public ScheduleLightDTO endHour(Time endHour) {
    this.endHour = endHour;
    return this;
  }

  /**
   * Get endHour
   * @return endHour
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Time getEndHour() {
    return endHour;
  }

  public void setEndHour(Time endHour) {
    this.endHour = endHour;
  }

  public ScheduleLightDTO hasBreak(Boolean hasBreak) {
    this.hasBreak = hasBreak;
    return this;
  }

  /**
   * Get hasBreak
   * @return hasBreak
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isHasBreak() {
    return hasBreak;
  }

  public void setHasBreak(Boolean hasBreak) {
    this.hasBreak = hasBreak;
  }

  public ScheduleLightDTO startBreak(Time startBreak) {
    this.startBreak = startBreak;
    return this;
  }

  /**
   * Get startBreak
   * @return startBreak
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Time getStartBreak() {
    return startBreak;
  }

  public void setStartBreak(Time startBreak) {
    this.startBreak = startBreak;
  }

  public ScheduleLightDTO endBreak(Time endBreak) {
    this.endBreak = endBreak;
    return this;
  }

  /**
   * Get endBreak
   * @return endBreak
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Time getEndBreak() {
    return endBreak;
  }

  public void setEndBreak(Time endBreak) {
    this.endBreak = endBreak;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScheduleLightDTO scheduleLightDTO = (ScheduleLightDTO) o;
    return Objects.equals(this.id, scheduleLightDTO.id) &&
        Objects.equals(this.day, scheduleLightDTO.day) &&
        Objects.equals(this.startHour, scheduleLightDTO.startHour) &&
        Objects.equals(this.endHour, scheduleLightDTO.endHour) &&
        Objects.equals(this.hasBreak, scheduleLightDTO.hasBreak) &&
        Objects.equals(this.startBreak, scheduleLightDTO.startBreak) &&
        Objects.equals(this.endBreak, scheduleLightDTO.endBreak);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, day, startHour, endHour, hasBreak, startBreak, endBreak);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScheduleLightDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    day: ").append(toIndentedString(day)).append("\n");
    sb.append("    startHour: ").append(toIndentedString(startHour)).append("\n");
    sb.append("    endHour: ").append(toIndentedString(endHour)).append("\n");
    sb.append("    hasBreak: ").append(toIndentedString(hasBreak)).append("\n");
    sb.append("    startBreak: ").append(toIndentedString(startBreak)).append("\n");
    sb.append("    endBreak: ").append(toIndentedString(endBreak)).append("\n");
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
