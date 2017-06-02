package com.codeart.tangdi.catfat.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/6/2.
 */

@Module
public class AppModule {
    private final Application mApplication;
    public AppModule(Application application){
        mApplication = application;
    }

    @Singleton
    @Provides
    public Context provideApplication(){
        return mApplication;
    }
}
