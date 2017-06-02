package com.codeart.tangdi.catfat.component;

import android.content.Context;

import com.codeart.tangdi.catfat.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/6/2.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Context getApplicationContext();//返回Application
}
