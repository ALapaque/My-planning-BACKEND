package eu.busi.myplanning.api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets CardType
 */
public enum CardType {
  MEETING("MEETING"),
    APPOINTMENT("APPOINTMENT");

  private String value;

  CardType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static CardType fromValue(String text) {
    for (CardType b : CardType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
