package es.nextdigital.atm.card.shared.cqrs;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface Listener<C> {

    @SuppressWarnings("unchecked")
    default Class<C> listenTo() {
        final Type[] typeArguments = ((ParameterizedType) getClass().getGenericInterfaces()[0]).getActualTypeArguments();
        return (Class<C>) typeArguments[0];
    }

}