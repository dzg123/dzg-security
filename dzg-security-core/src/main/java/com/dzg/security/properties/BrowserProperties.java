package com.dzg.security.properties;

import com.dzg.security.enums.LoginType;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: dzg-security
 * @description: browser配置类
 * @author: dzg
 * @create: 2019-02-07 20:28
 **/
public class BrowserProperties {
    private @Getter
    @Setter
    String loginPage = "/login.html";
    private @Getter
    @Setter
    LoginType loginType = LoginType.JSON;
    private @Getter
    @Setter
    int rememberMeSeconds = 3600;

    public BrowserProperties() {

    }
}
