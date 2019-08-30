package cn.jd.validation;

import lombok.Data;

/**
 * 前端返回信息
 * @param <T>
 */
@Data
public class RestResultWrapper<T> {
    private int code;
    private String message;
    private T result;
}
