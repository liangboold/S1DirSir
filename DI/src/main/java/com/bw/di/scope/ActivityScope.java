package com.bw.di.scope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Scope;

/*
 * @ClassName ImgUtil
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/10 19:09
 * @Version 1.0
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface ActivityScope {
}
