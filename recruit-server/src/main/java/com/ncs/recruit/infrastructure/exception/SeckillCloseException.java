package com.ncs.recruit.infrastructure.exception;

/**
 * 秒杀关闭异常
 * Created by chensen on 16/8/16.
 */
public class SeckillCloseException extends SeckillException {

    private static final long serialVersionUID = 2770030253435947973L;

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
