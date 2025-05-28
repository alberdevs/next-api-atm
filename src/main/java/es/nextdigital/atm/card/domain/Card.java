package es.nextdigital.atm.card.domain;

import es.nextdigital.atm.card.domain.entity.*;
import org.jspecify.annotations.NonNull;

import java.time.OffsetDateTime;

public class Card {
    private CardId id;
    private ClientId clientId;
    private AccountId accountId;
    private CardType cardType;
    private Activation activation;
    private Pin pin;
    private GlobalLimitAmount globalLimitAmount;
    private CreditLimitAmount creditLimitAmount;

    public Card(@NonNull CardId id, @NonNull ClientId clientId, @NonNull AccountId accountId,
                @NonNull CardType cardType, @NonNull Activation activation, @NonNull Pin pin,
                @NonNull GlobalLimitAmount globalLimitAmount, @NonNull CreditLimitAmount creditLimitAmount) {
        this.id = id;
        this.clientId = clientId;
        this.accountId = accountId;
        this.cardType = cardType;
        this.activation = activation;
        this.pin = pin;
        this.globalLimitAmount = globalLimitAmount;
        this.creditLimitAmount = creditLimitAmount;
    }

    public void changePin(int value, @NonNull OffsetDateTime changedDate) {
        this.pin = this.pin.changePin(value, changedDate);
    }

    public void activate(@NonNull OffsetDateTime activationDate) {
        this.activation = this.activation.activate(activationDate);
    }

}
