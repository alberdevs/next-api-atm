package es.nextdigital.atm.card.shared.cqrs;

public interface QueryBus {

  <R> R ask(Query<R> query);

}
