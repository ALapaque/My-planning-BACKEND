package eu.busi.myplanning.api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets CardSize
 */
public enum CardSize {
  TINY("tiny"),
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large"),
    GIANT("giant");

  private String value;

  CardSize(String value) {
    this.value = value;
  }

  @JsonCreator
  public static CardSize fromValue(String text) {
    for (CardSize b : CardSize.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }
}
