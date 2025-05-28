package es.nextdigital.atm.card.domain.entity;

import org.jspecify.annotations.NonNull;

import java.time.OffsetDateTime;

public record Activation(@NonNull boolean switchedOn, OffsetDateTime activationDate) {

    public Activation activate(final OffsetDateTime activationDate) {
        return new Activation(true, activationDate);
    }
}
