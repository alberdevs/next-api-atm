package es.nextdigital.atm.card.infrastructure.entity;

import es.nextdigital.atm.card.domain.entity.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "card")
@NoArgsConstructor
@Accessors(chain = true, fluent = true)
@Data
public class CardEntity {

    @Id
    private Long id;

    @Column
    private Long clientId;

    @Column
    private Long accountId;

    @Column
    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @Column
    private Boolean isActive;

    @Column
    private OffsetDateTime activatedAt;

    @Column
    private Integer pin;

    @Column
    private OffsetDateTime pinChangedAt;

    @Column
    private BigDecimal globalLimitAmount;

    @Column
    private BigDecimal creditLimitAmount;
}
