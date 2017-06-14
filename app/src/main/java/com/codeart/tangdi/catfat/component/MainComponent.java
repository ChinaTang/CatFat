package com.codeart.tangdi.catfat.component;

import com.codeart.tangdi.catfat.activity.MainActivity;
import com.codeart.tangdi.catfat.annotation.ActivityScope;
import com.codeart.tangdi.catfat.module.MainModule;

import dagger.Component;

/**
 * Created by Administrator on 2017/6/14.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}


