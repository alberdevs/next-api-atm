package es.nextdigital.atm.card.domain;

import es.nextdigital.atm.card.domain.entity.CardId;
import org.jspecify.annotations.NonNull;

import java.util.Optional;

public interface CardRepository {
    Optional<Card> findById(@NonNull CardId id);
}
