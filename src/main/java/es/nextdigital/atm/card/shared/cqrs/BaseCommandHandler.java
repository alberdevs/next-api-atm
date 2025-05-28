package es.nextdigital.atm.card.shared.cqrs;

public interface BaseCommandHandler<C extends BaseCommand<V>, V> extends Listener<C> {

  V execute(C command);
}
