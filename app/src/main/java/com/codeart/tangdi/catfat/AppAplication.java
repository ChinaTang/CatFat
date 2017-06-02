package com.codeart.tangdi.catfat;

import android.app.Application;

import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.codeart.tangdi.catfat.component.AppComponent;
import com.codeart.tangdi.catfat.component.DaggerAppComponent;
import com.codeart.tangdi.catfat.daggerhelp.HelpUtils;
import com.codeart.tangdi.catfat.module.AppModule;

/**
 * Created by tangdi on 6/1/17.
 */

public class AppAplication extends Application{

    private AppComponent mAppComponent;

    @Override
    public void onCreate(){
        super.onCreate();
        TypefaceProvider.registerDefaultIconSets();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        HelpUtils.getInstance().setAppComponent(mAppComponent);
    }
}
