package es.nextdigital.atm.card.shared.exception;

import java.io.Serial;
import es.nextdigital.atm.card.shared.Error;

public class ErrorException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = -3166191843755639366L;

  private final Error error;

  public ErrorException(final Error error) {
    super(error != null ? error.toString() : null);
    this.error = error;
  }

  public Error error() {
    return this.error;
  }
}
