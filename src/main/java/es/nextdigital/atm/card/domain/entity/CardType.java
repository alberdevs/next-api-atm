package es.nextdigital.atm.card.domain.entity;

import org.jspecify.annotations.NonNull;

public enum CardType {
    CREDIT("CREDIT"),
    DEBIT("DEBIT");

    private final String value;

    CardType(@NonNull String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
