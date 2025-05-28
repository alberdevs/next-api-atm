package es.nextdigital.atm.card.shared.cqrs;

public interface CommandBus {

  <T> T execute(BaseCommand<T> command);

}
