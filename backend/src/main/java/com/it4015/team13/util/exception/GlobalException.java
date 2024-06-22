package com.it4015.team13.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.it4015.team13.domain.response.RestResponse;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = { IdInValidException.class })
    public ResponseEntity<RestResponse<Object>> handleIdValidException(IdInValidException ex) {
        var rs = new RestResponse<>();
        rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
        rs.setError(ex.getMessage());
        rs.setMessage("Call api error");
        return ResponseEntity.badRequest().body(rs);
    }

}
