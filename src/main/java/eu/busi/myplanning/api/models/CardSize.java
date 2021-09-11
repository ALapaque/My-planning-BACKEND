package eu.busi.myplanning.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

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

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
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
}
