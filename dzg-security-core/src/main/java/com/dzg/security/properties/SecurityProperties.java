package com.dzg.security.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: dzg-security
 * @description: 总配置类
 * @author: dzg
 * @create: 2019-02-07 20:27
 **/
@ConfigurationProperties(prefix = "dzg.security")
public class SecurityProperties {
    @Autowired
    private @Getter @Setter BrowserProperties browser;

}
