package es.nextdigital.atm.card.shared.cqrs;

public interface CommandHandler<K extends Command> extends BaseCommandHandler<K, Void> {

  @Override
  default Void execute(final K command) {
    doHandle(command);
    return null;
  }

  void doHandle(K command);

}
