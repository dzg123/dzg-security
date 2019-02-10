package com.dzg.security.controller;

import com.dzg.security.dto.SimpleResponse;
import com.dzg.security.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: dzg-security
 * @description:
 * @author: dzg
 * @create: 2019-02-07 17:51
 **/
@RestController
@Slf4j
public class BrowserSecurityController {
    @Autowired
    private RequestCache requestCache;

    @Autowired
    private RedirectStrategy redirectStrategy;
    @Resource
    private SecurityProperties securityProperties;

    @RequestMapping("/authentication/require")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        log.info("引发跳转的请求是：{}", request.getRequestURL());
        if (savedRequest != null) {
            String target = savedRequest.getRedirectUrl();
            log.info("引发跳转的请求是：{}", target);
            if (target.endsWith(".html")) {
                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
            }

        }
        return new SimpleResponse("访问的服务器需要身份认证，请引导用户到登录页");

    }
}
