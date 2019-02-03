package com.dzg.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: dzg-security
 * @description: User异常统一处理类
 * @author: dzg
 * @create: 2019-02-03 14:44
 **/

public class UserNotExistException extends RuntimeException {
    private static final long serialVersionUID = -1217113030114570242L;
    private @Getter
    @Setter
    String id;
    private @Getter
    @Setter
    String message;

    public UserNotExistException(String message, String id) {
        super(message);
        this.id = id;
        this.message = message;


    }

}
