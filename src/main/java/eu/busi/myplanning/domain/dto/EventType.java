package eu.busi.myplanning.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets EventType
 */
public enum EventType {
  MEETING("MEETING"),
    APPOINTMENT("APPOINTMENT"),
    PRIVATE("PRIVATE"),
    DAYOFF("DAYOFF");

  private String value;

  EventType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static EventType fromValue(String text) {
    for (EventType b : EventType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
