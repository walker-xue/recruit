package com.ncs.recruit.infrastructure.exception;

/**
 * 秒杀相关业务异常
 * Created by chensen on 16/8/16.
 */
public class SeckillException extends RuntimeException {

    private static final long serialVersionUID = -5412652471016534425L;

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
