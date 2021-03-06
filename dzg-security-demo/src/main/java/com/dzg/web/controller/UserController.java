package com.dzg.web.controller;

import com.dzg.dto.User;
import com.dzg.dto.UserQueryCondition;
import com.dzg.exception.UserNotExistException;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: dzg-security
 * @description: User控制器
 * @author: dzg
 * @create: 2019-01-29 16:16
 **/
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @GetMapping("/me")
    @ApiOperation("权限认证服务")
    public Object getCurrentUser(Authentication authentication){
        return authentication;
//        return SecurityContextHolder.getContext().getAuthentication();
    }
    @PostMapping
    @ApiOperation("创建用户服务")
    public User create(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> log.info(error.getDefaultMessage()));
        }
        log.info(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
        user.setId(1);
        return user;

    }

    @PutMapping("/{id:\\d+}")
    @ApiOperation("用户更新服务")
    public User update(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
//                FieldError fieldError = (FieldError) error;
//                String message = fieldError.getField() + "\t" + error.getDefaultMessage();
                log.info(error.getDefaultMessage());
            });
        }
        log.info(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
        return user;

    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    @ApiOperation(value = "用户查询服务")
    public List<User> query(UserQueryCondition condition, @PageableDefault(page = 0, size = 15, sort = "age,asc") Pageable pageable) {
        log.info(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
        log.info(ReflectionToStringBuilder.toString(pageable, ToStringStyle.MULTI_LINE_STYLE));
        ArrayList<User> list = Lists.newArrayList();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        return list;
    }

    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@ApiParam("用户id")@PathVariable("id") String id) {
//        throw new UserNotExistException("user not exist22",id);
        log.info("进入getInfo方法");
        User user = new User();
        user.setUsername("dzg");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    @ApiOperation("用户删除服务")
    public void delete(@PathVariable String id) {
        log.info("id:{}", id);

    }
}
