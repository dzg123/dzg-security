package com.dzg.security.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: dzg-security
 * @description: 简单对象
 * @author: dzg
 * @create: 2019-02-07 18:39
 **/
public class SimpleResponse {
    private @Getter
    @Setter
    Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }
}
