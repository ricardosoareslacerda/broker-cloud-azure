package br.com.fiap.broker.dronemonitorproducer.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * InternError
 */
@RequiredArgsConstructor
@AllArgsConstructor
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class InternError extends RuntimeException {

  @JsonProperty("message")
  private String message = null;

  public InternError message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
