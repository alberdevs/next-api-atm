package es.nextdigital.atm.card.infrastructure.repository;

import es.nextdigital.atm.card.domain.Card;
import es.nextdigital.atm.card.domain.CardRepository;
import es.nextdigital.atm.card.domain.entity.CardId;
import es.nextdigital.atm.card.infrastructure.mapper.CardEntityMapper;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CardRepositoryImpl implements CardRepository {

    private final CardRepositoryJpa cardRepositoryJpa;
    private final CardEntityMapper cardEntityMapper;

    @Override
    public Optional<Card> findById(@NonNull CardId id) {
        return cardRepositoryJpa.findById(id.value()).map(cardEntityMapper::toDomain);
    }
}
