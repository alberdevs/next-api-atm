package es.nextdigital.atm.card.infrastructure.mapper;

import es.nextdigital.atm.card.domain.Card;
import es.nextdigital.atm.card.domain.entity.*;
import es.nextdigital.atm.card.infrastructure.entity.CardEntity;
import org.springframework.stereotype.Component;

@Component
public class CardEntityMapper {
    public Card toDomain(final CardEntity cardEntity) {
        return new Card(
                new CardId(cardEntity.id()),
                new ClientId(cardEntity.clientId()),
                new AccountId(cardEntity.accountId()),
                cardEntity.cardType(),
                new Activation(cardEntity.isActive(), cardEntity.activatedAt()),
                new Pin(cardEntity.pin(), cardEntity.pinChangedAt()),
                new GlobalLimitAmount(cardEntity.globalLimitAmount()),
                new CreditLimitAmount(cardEntity.creditLimitAmount())
        );
    }
}
