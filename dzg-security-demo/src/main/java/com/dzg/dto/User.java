package com.dzg.dto;

import com.dzg.validator.MyConstraint;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @program: dzg-security
 * @description: UserDto
 * @author: dzg
 * @create: 2019-01-29 16:34
 **/
@Data
public class User  {
    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView {};
    @JsonView(UserSimpleView.class)
    private Integer id;
    @JsonView(UserSimpleView.class)
    @MyConstraint(message = "这是dzg第一个自定义校验注解")
    private String username;
    @JsonView(UserDetailView.class)
    @NotBlank(message = "密码不能为空")
    private String password;
    @Past(message = "生日必须是过去的时间")
    @JsonView(UserSimpleView.class)
    private Date birthday;

}
