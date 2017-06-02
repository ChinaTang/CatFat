package com.codeart.tangdi.catfat.annotation;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2017/6/2.
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {}
