package com.codeart.tangdi.catfat.component;

import com.codeart.tangdi.catfat.activity.AdvertisementActivity;
import com.codeart.tangdi.catfat.annotation.ActivityScope;
import com.codeart.tangdi.catfat.module.AdvertisementModule;

import dagger.Component;

/**
 * Created by Administrator on 2017/6/2.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = AdvertisementModule.class)
public interface AdvertisementComponent {
    void inject(AdvertisementActivity advActivity);
}
