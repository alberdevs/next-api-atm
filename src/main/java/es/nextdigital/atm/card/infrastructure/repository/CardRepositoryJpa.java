package es.nextdigital.atm.card.infrastructure.repository;

import es.nextdigital.atm.card.infrastructure.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepositoryJpa extends JpaRepository<CardEntity, Long> {
}
