package com.dzg.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

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
    private String username;
    @JsonView(UserDetailView.class)
    private String password;

}
