package my.social.social.exception;

import lombok.extern.slf4j.Slf4j;
import my.social.social.util.AppError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AppError handleUserNotFound(final UserNotFoundException e) {
        log.error(e.getMessage(), e);
        return new AppError(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AppError handleUserNotFound(final NewsNotFoundException e) {
        log.error(e.getMessage(), e);
        return new AppError(e.getMessage());
    }
}
