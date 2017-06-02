package com.codeart.tangdi.catfat.component;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.codeart.tangdi.catfat.module.AppModule;
import com.codeart.tangdi.catfat.netrequest.VolleyRequest;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/6/2.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Context getApplicationContext();//返回Application

    RequestQueue getRequestQueue();//返回RequestQueue

    VolleyRequest getVolleyRequest();//返回VolleyRequest
}
