package es.nextdigital.atm.card.shared.cqrs.impl;

import es.nextdigital.atm.card.shared.cqrs.BaseCommand;
import es.nextdigital.atm.card.shared.cqrs.BaseCommandHandler;
import es.nextdigital.atm.card.shared.cqrs.CommandBus;
import es.nextdigital.atm.card.shared.cqrs.Listener;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SpringCommandBus<K extends BaseCommand<V>, V> implements CommandBus {
    private static final Logger log = LoggerFactory.getLogger(SpringCommandBus.class);
    private final Map<Class<?>, BaseCommandHandler<K, V>> handlers;

    public SpringCommandBus(final Set<? extends BaseCommandHandler<K, V>> commandHandlers) {
        this.handlers = (Map)commandHandlers.stream().collect(Collectors.toMap(Listener::listenTo, (handler) -> handler));
    }

    public <T> T execute(final BaseCommand<T> command) {
        log.info("Executing {}", command);
        return (T)((BaseCommandHandler)this.handlers.computeIfAbsent(command.getClass(), (s) -> {
            throw NotAvailableHandlerException.forCommand(command);
        })).execute(command);
    }
}