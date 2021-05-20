package com.upgrad.technical.api.exception;

import com.upgrad.technical.api.model.ErrorResponse;
import com.upgrad.technical.service.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<ErrorResponse> authenticationFailedException(AuthenticationFailedException exc, WebRequest request) {
//        return new ResponseEntity<ErrorResponse>(
//                new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.UNAUTHORIZED
//        );
        return null;
    }

    @ExceptionHandler(UploadFailedException.class)
    public ResponseEntity<ErrorResponse> uploadFailedException(UploadFailedException exc, WebRequest request) {
//        return new ResponseEntity<ErrorResponse>(
//                new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.UNAUTHORIZED
//        );
        return null;
    }

    @ExceptionHandler(ImageNotFoundException.class)
    public ResponseEntity<ErrorResponse> imagenotfoundException(ImageNotFoundException exc, WebRequest request) {
//        return new ResponseEntity<ErrorResponse>(
//                new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.NOT_FOUND
//        );
        return null;
    }

    @ExceptionHandler(UserNotSignedInException.class)
    public ResponseEntity<ErrorResponse> usernotsignedinException(UserNotSignedInException exc, WebRequest request) {
//        return new ResponseEntity<ErrorResponse>(
//                new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.UNAUTHORIZED
//        );
        return null;
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> unauthorizedException(UnauthorizedException exc, WebRequest request) {
//        return new ResponseEntity<ErrorResponse>(
//                new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.FORBIDDEN
//        );
        return null;
    }

}