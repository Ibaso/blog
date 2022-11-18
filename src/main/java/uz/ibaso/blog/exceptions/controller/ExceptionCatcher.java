package uz.ibaso.blog.exceptions.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.ibaso.blog.db.dto.ErrorMessageDto;
import uz.ibaso.blog.exceptions.AccessDeniedException;
import uz.ibaso.blog.exceptions.UserNotFoundException;

@RestControllerAdvice
public class ExceptionCatcher {
    @ExceptionHandler(value = {UserNotFoundException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessageDto exception(UserNotFoundException exception) {
        return new ErrorMessageDto(512, "User not found");
    }

    @ExceptionHandler(value = {AccessDeniedException.class})
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessageDto exception(AccessDeniedException exception) {
        return new ErrorMessageDto(406, "Access Denied");
    }
}
