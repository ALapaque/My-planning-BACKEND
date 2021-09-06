package eu.busi.myplanning.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.sql.Time;
import java.util.Objects;

/**
 * ScheduleDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-06T09:55:51.442971500+02:00[Europe/Berlin]")
public class ScheduleDTO   {
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

  @JsonProperty("agenda")
  private AgendaLightDTO agenda = null;

  public ScheduleDTO id(Long id) {
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

  public ScheduleDTO day(Integer day) {
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

  public ScheduleDTO startHour(Time startHour) {
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

  public ScheduleDTO endHour(Time endHour) {
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

  public ScheduleDTO hasBreak(Boolean hasBreak) {
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

  public ScheduleDTO startBreak(Time startBreak) {
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

  public ScheduleDTO endBreak(Time endBreak) {
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

  public ScheduleDTO agenda(AgendaLightDTO agenda) {
    this.agenda = agenda;
    return this;
  }

  /**
   * Get agenda
   * @return agenda
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public AgendaLightDTO getAgenda() {
    return agenda;
  }

  public void setAgenda(AgendaLightDTO agenda) {
    this.agenda = agenda;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScheduleDTO scheduleDTO = (ScheduleDTO) o;
    return Objects.equals(this.id, scheduleDTO.id) &&
        Objects.equals(this.day, scheduleDTO.day) &&
        Objects.equals(this.startHour, scheduleDTO.startHour) &&
        Objects.equals(this.endHour, scheduleDTO.endHour) &&
        Objects.equals(this.hasBreak, scheduleDTO.hasBreak) &&
        Objects.equals(this.startBreak, scheduleDTO.startBreak) &&
        Objects.equals(this.endBreak, scheduleDTO.endBreak) &&
        Objects.equals(this.agenda, scheduleDTO.agenda);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, day, startHour, endHour, hasBreak, startBreak, endBreak, agenda);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScheduleDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    day: ").append(toIndentedString(day)).append("\n");
    sb.append("    startHour: ").append(toIndentedString(startHour)).append("\n");
    sb.append("    endHour: ").append(toIndentedString(endHour)).append("\n");
    sb.append("    hasBreak: ").append(toIndentedString(hasBreak)).append("\n");
    sb.append("    startBreak: ").append(toIndentedString(startBreak)).append("\n");
    sb.append("    endBreak: ").append(toIndentedString(endBreak)).append("\n");
    sb.append("    agenda: ").append(toIndentedString(agenda)).append("\n");
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
