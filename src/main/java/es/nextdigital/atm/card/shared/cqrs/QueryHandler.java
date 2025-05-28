package es.nextdigital.atm.card.shared.cqrs;

public interface QueryHandler<Q extends Query<R>, R> extends Listener<Q> {

  R ask(Q query);

}
