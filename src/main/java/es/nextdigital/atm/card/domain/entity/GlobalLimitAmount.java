package es.nextdigital.atm.card.domain.entity;

import org.jspecify.annotations.NonNull;

import java.math.BigDecimal;

public record GlobalLimitAmount(@NonNull BigDecimal value) {
}
