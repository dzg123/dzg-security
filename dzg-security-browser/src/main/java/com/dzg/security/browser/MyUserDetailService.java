package com.dzg.security.browser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @program: dzg-security
 * @description: 用户信息获取类
 * @author: dzg
 * @create: 2019-02-05 21:35
 **/
@Component
@Slf4j
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("登录用户名：{}", s);
//        根据用户名查找用户信息(根据各自实际需求来查找用户密码、权限等信息)
//        根据查找到的用户信息判断用户是否被冻结
        String password = passwordEncoder.encode("1234");
        log.info("数据库密码：{}", password);
        return new User(s, password, true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
