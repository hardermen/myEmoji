package com.littlehelper.fabiaoqing.response;

import lombok.Data;

/**
 * Api返回公共类
 *
 * @author littlehelper
 * @date 2019-05-23
 */
@Data
public class ApiResult {
    private Integer code;
    private String message;
    private Object data;

    public static ApiResult create(Integer code, String message, Object data) {
        ApiResult api = new ApiResult();
        api.setCode(code);
        api.setMessage(message);
        api.setData(data);
        return api;
    }

    public static ApiResult success(String message, Object data) {
        return ApiResult.create(ResponseEnum.SUCCESS.getCode(), message, data);
    }

    public static ApiResult success(Object data) {
        return ApiResult.success(ResponseEnum.SUCCESS.getMessage(), data);
    }

    public static ApiResult failure(Integer code, String message) {
        return ApiResult.create(code, message, null);
    }
}
