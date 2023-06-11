package eu.busi.myplanning.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import eu.busi.myplanning.api.models.EventStatus;
import eu.busi.myplanning.api.models.EventType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.Instant;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EventLightDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-11T17:10:17.226883800+02:00[Europe/Paris]")
public class EventLightDTO   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("createdAt")
  private Instant createdAt = null;

  @JsonProperty("updatedAt")
  private Instant updatedAt = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("statusDisplayed")
  private EventStatus statusDisplayed = null;

  @JsonProperty("eventType")
  private EventType eventType = null;

  @JsonProperty("startDate")
  private Instant startDate = null;

  @JsonProperty("endDate")
  private Instant endDate = null;

  @JsonProperty("meetingUrl")
  private String meetingUrl = null;

  @JsonProperty("report")
  private String report = null;

  @JsonProperty("privateEvent")
  private Boolean privateEvent = null;

  @JsonProperty("dayOff")
  private Boolean dayOff = null;

  public EventLightDTO id(Long id) {
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

  public EventLightDTO createdAt(Instant createdAt) {
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

  public EventLightDTO updatedAt(Instant updatedAt) {
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

  public EventLightDTO name(String name) {
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

  public EventLightDTO statusDisplayed(EventStatus statusDisplayed) {
    this.statusDisplayed = statusDisplayed;
    return this;
  }

  /**
   * Get statusDisplayed
   * @return statusDisplayed
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public EventStatus getStatusDisplayed() {
    return statusDisplayed;
  }

  public void setStatusDisplayed(EventStatus statusDisplayed) {
    this.statusDisplayed = statusDisplayed;
  }

  public EventLightDTO eventType(EventType eventType) {
    this.eventType = eventType;
    return this;
  }

  /**
   * Get eventType
   * @return eventType
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public EventType getEventType() {
    return eventType;
  }

  public void setEventType(EventType eventType) {
    this.eventType = eventType;
  }

  public EventLightDTO startDate(Instant startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Instant getStartDate() {
    return startDate;
  }

  public void setStartDate(Instant startDate) {
    this.startDate = startDate;
  }

  public EventLightDTO endDate(Instant endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Instant getEndDate() {
    return endDate;
  }

  public void setEndDate(Instant endDate) {
    this.endDate = endDate;
  }

  public EventLightDTO meetingUrl(String meetingUrl) {
    this.meetingUrl = meetingUrl;
    return this;
  }

  /**
   * Get meetingUrl
   * @return meetingUrl
  **/
  @ApiModelProperty(value = "")
  
    public String getMeetingUrl() {
    return meetingUrl;
  }

  public void setMeetingUrl(String meetingUrl) {
    this.meetingUrl = meetingUrl;
  }

  public EventLightDTO report(String report) {
    this.report = report;
    return this;
  }

  /**
   * Get report
   * @return report
  **/
  @ApiModelProperty(value = "")
  
    public String getReport() {
    return report;
  }

  public void setReport(String report) {
    this.report = report;
  }

  public EventLightDTO privateEvent(Boolean privateEvent) {
    this.privateEvent = privateEvent;
    return this;
  }

  /**
   * Get privateEvent
   * @return privateEvent
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isPrivateEvent() {
    return privateEvent;
  }

  public void setPrivateEvent(Boolean privateEvent) {
    this.privateEvent = privateEvent;
  }

  public EventLightDTO dayOff(Boolean dayOff) {
    this.dayOff = dayOff;
    return this;
  }

  /**
   * Get dayOff
   * @return dayOff
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isDayOff() {
    return dayOff;
  }

  public void setDayOff(Boolean dayOff) {
    this.dayOff = dayOff;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventLightDTO eventLightDTO = (EventLightDTO) o;
    return Objects.equals(this.id, eventLightDTO.id) &&
        Objects.equals(this.createdAt, eventLightDTO.createdAt) &&
        Objects.equals(this.updatedAt, eventLightDTO.updatedAt) &&
        Objects.equals(this.name, eventLightDTO.name) &&
        Objects.equals(this.statusDisplayed, eventLightDTO.statusDisplayed) &&
        Objects.equals(this.eventType, eventLightDTO.eventType) &&
        Objects.equals(this.startDate, eventLightDTO.startDate) &&
        Objects.equals(this.endDate, eventLightDTO.endDate) &&
        Objects.equals(this.meetingUrl, eventLightDTO.meetingUrl) &&
        Objects.equals(this.report, eventLightDTO.report) &&
        Objects.equals(this.privateEvent, eventLightDTO.privateEvent) &&
        Objects.equals(this.dayOff, eventLightDTO.dayOff);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdAt, updatedAt, name, statusDisplayed, eventType, startDate, endDate, meetingUrl, report, privateEvent, dayOff);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventLightDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    statusDisplayed: ").append(toIndentedString(statusDisplayed)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    meetingUrl: ").append(toIndentedString(meetingUrl)).append("\n");
    sb.append("    report: ").append(toIndentedString(report)).append("\n");
    sb.append("    privateEvent: ").append(toIndentedString(privateEvent)).append("\n");
    sb.append("    dayOff: ").append(toIndentedString(dayOff)).append("\n");
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
