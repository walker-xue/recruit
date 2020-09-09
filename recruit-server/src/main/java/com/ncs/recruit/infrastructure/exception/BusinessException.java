package com.ncs.recruit.infrastructure.exception;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义业务异常处理类 友好提示
 *
 * @author lyl
 * @date 2015年12月14日
 */
@Slf4j
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 3152616724785436891L;

    public static String json;

    public BusinessException(String errorMsg, Number errorCode) {
        super(createFriendlyErrMsg(errorMsg, errorCode));
    }

    public BusinessException(Throwable throwable) {
        super(throwable);
    }

    public BusinessException(Throwable throwable, String errorMsg,
        Number errorCode) {
        super(throwable);
    }

    private static String createFriendlyErrMsg(String msgBody, Number errorCode) {
        if (msgBody.contains("success") && msgBody.contains("errorCode") && msgBody.contains("msg")) {
            json = msgBody.substring(msgBody.indexOf("{"), msgBody.indexOf("}") + 1);
            log.info(json);
            return json;
        }

        StringBuffer friendlyErrMsg = new StringBuffer();
        friendlyErrMsg.append("抱歉，");
        friendlyErrMsg.append(msgBody);
        friendlyErrMsg.append("，请稍后再试或与管理员联系。");
        json = JSON.toJSONString(friendlyErrMsg.toString());
        log.info(json);
        return json;
    }
}  