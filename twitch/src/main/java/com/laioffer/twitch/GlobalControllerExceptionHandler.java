package com.laioffer.twitch;


import com.laioffer.twitch.model.TwitchErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;


@ControllerAdvice
public class GlobalControllerExceptionHandler {
    // 所有其他细分的 Controller 运行下（call Service）出现的 Exception 统一在这处理

    // Handle 所有没见过的 Exceptions.
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<TwitchErrorResponse> handleDefaultException(Exception e) {
        return new ResponseEntity<>(
                new TwitchErrorResponse("Something went wrong, please try again later.",
                        e.getClass().getName(),
                        e.getMessage()
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    // Handle 所有 Controller throw 出来的明确的 Bad Request Codes.
    @ExceptionHandler(ResponseStatusException.class)
    public final ResponseEntity<TwitchErrorResponse> handleResponseStatusException(ResponseStatusException e) {
        return new ResponseEntity<>(
                new TwitchErrorResponse(e.getReason(), e.getCause().getClass().getName(), e.getCause().getMessage()),
                e.getStatusCode()
        );
    }
}
