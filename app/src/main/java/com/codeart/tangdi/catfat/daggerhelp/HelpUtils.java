package com.codeart.tangdi.catfat.daggerhelp;

import com.codeart.tangdi.catfat.component.AppComponent;

/**
 * Created by Administrator on 2017/6/2.
 */

public class HelpUtils {
    private static HelpUtils _instance = null;
    private AppComponent mAppComponent;
    private HelpUtils(){

    }
    public static HelpUtils getInstance(){
        if(_instance == null){
            _instance = new HelpUtils();
        }
        return _instance;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public void setAppComponent(AppComponent appComponent) {
        mAppComponent = appComponent;
    }
}
