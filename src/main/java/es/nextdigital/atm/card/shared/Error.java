package es.nextdigital.atm.card.shared;

import java.io.Serializable;

public sealed interface Error extends Serializable {
  record MessageError(String reason) implements Error {
  }

  record NotFound(String notFoundResourceId) implements Error {
  }

  record BadRequest(String reason) implements Error {
  }
}
