package com.dzg.dto;

import lombok.Data;

/**
 * @program: dzg-security
 * @description: 查询条件封装对象
 * @author: dzg
 * @create: 2019-01-29 17:05
 **/
@Data
public class UserQueryCondition {
    private  String username;
    private int age;
    private int ageTo;
    private String xxx;
}
