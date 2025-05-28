package es.nextdigital.atm.card.application;

import es.nextdigital.atm.card.shared.cqrs.Command;
import org.jspecify.annotations.NonNull;

public record ActivateCardCommand(@NonNull Long id) implements Command {
}
