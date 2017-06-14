package com.codeart.tangdi.catfat.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.codeart.tangdi.catfat.activity.impview.IMainView;
import com.codeart.tangdi.catfat.component.DaggerMainComponent;
import com.codeart.tangdi.catfat.daggerhelp.HelpUtils;
import com.codeart.tangdi.catfat.module.MainModule;
import com.codeart.tangdi.catfat.presenter.presenterinterface.IMainPersenter;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/6/14.
 */

public class MainActivity extends AppCompatActivity implements IMainView{


    @Inject
    IMainPersenter mMainPersenter;

    @Override
    public void onCreate(Bundle saveInstanceBundle){
        super.onCreate(saveInstanceBundle);

        DaggerMainComponent.builder().mainModule(new MainModule(this)).appComponent(HelpUtils.getInstance().getAppComponent()).build();
    }
}
