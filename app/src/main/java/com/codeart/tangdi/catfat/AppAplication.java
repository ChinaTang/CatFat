package com.codeart.tangdi.catfat;

import android.app.Application;

import com.beardedhen.androidbootstrap.TypefaceProvider;

/**
 * Created by tangdi on 6/1/17.
 */

public class AppAplication extends Application{
    @Override
    public void onCreate(){
        super.onCreate();
        TypefaceProvider.registerDefaultIconSets();
    }
}
