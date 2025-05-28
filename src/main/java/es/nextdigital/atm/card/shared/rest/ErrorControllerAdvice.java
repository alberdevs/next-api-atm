package es.nextdigital.atm.card.shared.rest;

import es.nextdigital.atm.card.shared.Error;
import es.nextdigital.atm.card.shared.exception.ErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorControllerAdvice {

    public static final String RESOURCE_NOT_FOUND = "Resource not found with id %s";

    @ExceptionHandler(ErrorException.class)
    public ProblemDetail handleDomainErrorException(final ErrorException ex, final WebRequest request) {
        if (ex.error() instanceof Error.NotFound) {
            return this.handleNotFoundError(ex, request);
        }
        return this.handleGenericError(ex, request);
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleGeneric(Exception ex, WebRequest request) {
        return this.handleGenericError(new ErrorException(new Error.MessageError(ex.getMessage())), request);
    }

    private ProblemDetail handleNotFoundError(final ErrorException ex, final WebRequest request) {
        final var httpStatus = HttpStatus.NOT_FOUND;
        return ProblemDetail.forStatusAndDetail(
                httpStatus,
                String.format(RESOURCE_NOT_FOUND, ((Error.NotFound) ex.error()).notFoundResourceId()));
    }

    private ProblemDetail handleGenericError(final ErrorException ex, final WebRequest request) {
        final var httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return ProblemDetail.forStatus(httpStatus);
    }


}
