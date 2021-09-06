package eu.busi.myplanning.api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets EventStatus
 */
public enum EventStatus {
  BUSY("BUSY"),
    FREE("FREE"),
    AWAY("AWAY");

  private String value;

  EventStatus(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static EventStatus fromValue(String text) {
    for (EventStatus b : EventStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
