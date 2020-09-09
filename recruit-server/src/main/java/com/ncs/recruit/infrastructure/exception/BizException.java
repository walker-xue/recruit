package com.ncs.recruit.infrastructure.exception;

/**
 * 业务异常
 *
 * @author wphou
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -4591116842075354978L;

    public BizException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public BizException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public BizException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

}
