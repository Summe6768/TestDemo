package com.app.summer.testdemo.Dagger2.ano;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author: Summer
 * @date: 2019/5/14
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface Release {
}
