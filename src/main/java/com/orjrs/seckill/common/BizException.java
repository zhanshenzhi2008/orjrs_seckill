package com.orjrs.seckill.common;

/**
 * 业务异常
 *
 * @author orjrs
 * @date 2018-06-30 15:50
 */
public class BizException extends RuntimeException {
    public BizException(String message) {
        super(message);
    }
}
