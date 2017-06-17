package com.codeart.tangdi.catfat.component

import com.codeart.tangdi.catfat.activity.MainActivity
import com.codeart.tangdi.catfat.annotation.ActivityScope
import com.codeart.tangdi.catfat.module.MainModule
import dagger.Component

/**
 * Created by tangdi on 6/17/17.
 */
@ActivityScope
@Component(modules = arrayOf(MainModule::class), dependencies = arrayOf(AppComponent::class))
interface MainComponent{
    fun inject(activity: MainActivity)
}
