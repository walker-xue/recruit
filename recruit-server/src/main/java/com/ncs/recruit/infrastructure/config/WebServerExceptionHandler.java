package com.ncs.recruit.infrastructure.config;

import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.skunk.web.HttpCode;
import com.github.skunk.web.config.AbstractExceptionHandler;
import com.ncs.recruit.infrastructure.security.UnauthorizedException;

import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常处理
 *
 * @author walker
 */
@Slf4j
@RestControllerAdvice
public class WebServerExceptionHandler extends AbstractExceptionHandler {

    /**
     * 未授权访问
     *
     * @param ex
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = { UnauthorizedException.class })
    public ResponseEntity<Map<String, Object>> unauthorizedException(UnauthorizedException ex) {
        log.warn(ex.getMessage(), ex);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(MESSAGE_KEY, ex.getMessage());
        parameters.put(HTTP_STATUS_KEY, ex.getCode());
        return new ResponseEntity<>(parameters, HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     * 用户凭证异常处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = { BadCredentialsException.class })
    public ResponseEntity<Map<String, Object>> userNotFoundException(BadCredentialsException ex) {
        log.warn(ex.getMessage(), ex);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(MESSAGE_KEY, HttpCode._4000_BAD_CREDENTIALS.message);
        parameters.put(HTTP_STATUS_KEY, HttpCode._4000_BAD_CREDENTIALS.status);
        return new ResponseEntity<>(parameters, HttpStatus.BAD_REQUEST);
    }

    /**
     * 超时异常处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = { SocketTimeoutException.class })
    public ResponseEntity<Map<String, Object>> socketTimeoutException(SocketTimeoutException ex) {
        log.warn(ex.getMessage(), ex);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(MESSAGE_KEY, HttpCode.INTERNAL_SERVER_ERROR.message);
        parameters.put(HTTP_STATUS_KEY, HttpCode.INTERNAL_SERVER_ERROR.status);
        return new ResponseEntity<>(parameters, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
