package com.dzg.dto;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "用户年龄起始值")
    private int age;
    @ApiModelProperty("用户年龄终止值")
    private int ageTo;
    private String xxx;
}
