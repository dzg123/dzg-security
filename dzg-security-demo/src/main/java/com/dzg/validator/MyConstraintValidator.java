package com.dzg.validator;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @program: dzg-security
 * @description: 自定义校验类
 * @author: dzg
 * @create: 2019-01-30 22:23
 **/
@Slf4j
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {
    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        log.info("my Validator init");
    }

    @Override
    public boolean isValid(Object s, ConstraintValidatorContext constraintValidatorContext) {
        log.info(String.valueOf(s));
        return false;
    }
}
