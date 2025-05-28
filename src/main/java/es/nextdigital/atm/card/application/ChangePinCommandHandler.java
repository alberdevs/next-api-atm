package es.nextdigital.atm.card.application;

import es.nextdigital.atm.card.domain.CardRepository;
import es.nextdigital.atm.card.domain.entity.CardId;
import es.nextdigital.atm.card.shared.Error;
import es.nextdigital.atm.card.shared.cqrs.Command;
import es.nextdigital.atm.card.shared.cqrs.CommandHandler;
import es.nextdigital.atm.card.shared.exception.ErrorException;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@RequiredArgsConstructor
public class ChangePinCommandHandler implements CommandHandler<ChangePinCommand> {

    private final CardRepository cardRepository;

    @Override
    public void doHandle(final ChangePinCommand command) {
        cardRepository.findById(new CardId(command.id()))
                .ifPresentOrElse(card -> card.changePin(command.pin(), OffsetDateTime.now()), () -> {
                    throw new ErrorException(new Error.NotFound("Card not found"));
                });
    }
}
