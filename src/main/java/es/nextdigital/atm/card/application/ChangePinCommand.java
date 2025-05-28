package es.nextdigital.atm.card.application;

import es.nextdigital.atm.card.shared.cqrs.Command;
import org.jspecify.annotations.NonNull;

public record ChangePinCommand(@NonNull Long id, @NonNull int pin) implements Command {
}
