package es.nextdigital.atm.card.shared.cqrs.impl;

import es.nextdigital.atm.card.shared.cqrs.BaseCommand;
import es.nextdigital.atm.card.shared.cqrs.Query;

public class NotAvailableHandlerException extends RuntimeException {
    private static final String TEMPLATE = "No handler for %s";

    public NotAvailableHandlerException(final String message) {
        super(message);
    }

    public static NotAvailableHandlerException forQuery(final Query<?> query) {
        return new NotAvailableHandlerException(String.format("No handler for %s", query.getClass().getName()));
    }

    public static NotAvailableHandlerException forCommand(final BaseCommand<?> command) {
        return new NotAvailableHandlerException(String.format("No handler for %s", command.getClass().getName()));
    }

}