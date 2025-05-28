package es.nextdigital.atm.card.domain.entity;

import org.jspecify.annotations.NonNull;

import java.time.OffsetDateTime;
import java.util.Objects;

public class Pin {
    private final int value;
    private final OffsetDateTime changedAt;

    public Pin(int value, OffsetDateTime changedAt) {
        this.value = Objects.hash(value);
        this.changedAt = changedAt;
    }

    public Pin(int value) {
        this(value, null);
    }

    public Pin changePin(int value, @NonNull OffsetDateTime changedDate) {
        return new Pin(value, changedDate);
    }

}
