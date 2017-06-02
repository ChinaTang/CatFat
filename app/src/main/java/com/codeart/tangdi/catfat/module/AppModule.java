package com.codeart.tangdi.catfat.module;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.codeart.tangdi.catfat.netrequest.VolleyRequest;

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

    @Singleton
    @Provides
    public RequestQueue provideRequestQueue(){
        return Volley.newRequestQueue(mApplication);
    }

    @Singleton
    @Provides
    public VolleyRequest provideVolleyRequest(){
        return new VolleyRequest();
    }
}
