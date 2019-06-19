package com.littlehelper.fabiaoqing.expection;

import com.littlehelper.fabiaoqing.response.ResponseEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 业务异常
 *
 * @author littlehelper
 * @date 2019-05-24
 */
public class BusinessException extends Exception {
    @Getter
    @Setter
    private Integer code;

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ResponseEnum responseEnum) {
        super(responseEnum.getMessage());
        this.code = responseEnum.getCode();
    }
}
