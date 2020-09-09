package com.ncs.recruit.infrastructure.exception;

/**
 * 重复秒杀异常(运行期异常)
 * Created by chensen on 16/8/16.
 */
public class RepeatKillException extends SeckillException {

    private static final long serialVersionUID = -1074336220805304986L;

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
