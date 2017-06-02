package com.codeart.tangdi.catfat.activity;

import android.os.Bundle;

import com.codeart.tangdi.catfat.R;
import com.codeart.tangdi.catfat.activity.impview.IadvertisementView;
import com.codeart.tangdi.catfat.base.BaseActivity;
import com.codeart.tangdi.catfat.component.DaggerAdvertisementComponent;
import com.codeart.tangdi.catfat.daggerhelp.HelpUtils;
import com.codeart.tangdi.catfat.module.AdvertisementModule;
import com.codeart.tangdi.catfat.presenter.presenterinterface.IAdvertisementPersenter;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/6/2.
 */

public class AdvertisementActivity extends BaseActivity implements IadvertisementView {

    @Inject
    IAdvertisementPersenter mPersenter;
    @Override
    public void onCreate(Bundle SaveInstanceBundle){
        super.onCreate(SaveInstanceBundle);
        setContentView(R.layout.activity_main);
        if(mPersenter != null){

        }
    }

    @Override
    protected void initMvp() {
        DaggerAdvertisementComponent.builder().advertisementModule(new AdvertisementModule(this))
                                    .appComponent(HelpUtils.getInstance().getAppComponent())
                                    .build().inject(this);
    }
}
