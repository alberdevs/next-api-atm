package es.nextdigital.atm.card.application;

import es.nextdigital.atm.card.domain.CardRepository;
import es.nextdigital.atm.card.domain.entity.CardId;
import es.nextdigital.atm.card.shared.Error.NotFound;
import es.nextdigital.atm.card.shared.cqrs.CommandHandler;
import es.nextdigital.atm.card.shared.exception.ErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@RequiredArgsConstructor
public class ActivateCardCommandHandler implements CommandHandler<ActivateCardCommand> {

    private final CardRepository cardRepository;

    @Override
    public void doHandle(final ActivateCardCommand command) {
        cardRepository.findById(new CardId(command.id()))
                .ifPresentOrElse(card -> card.activate(OffsetDateTime.now()), () -> {
                    throw new ErrorException(new NotFound("Card not found"));
                });
    }
}
