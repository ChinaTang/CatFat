package com.codeart.tangdi.catfat.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.codeart.tangdi.catfat.R;
import com.codeart.tangdi.catfat.activity.impview.IadvertisementView;
import com.codeart.tangdi.catfat.base.BaseActivity;
import com.codeart.tangdi.catfat.component.DaggerAdvertisementComponent;
import com.codeart.tangdi.catfat.daggerhelp.HelpUtils;
import com.codeart.tangdi.catfat.module.AdvertisementModule;
import com.codeart.tangdi.catfat.presenter.presenterinterface.IAdvertisementPersenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/6/2.
 */

public class AdvertisementActivity extends BaseActivity implements IadvertisementView {

    @Inject
    IAdvertisementPersenter mPersenter;

    @BindView(R.id.adv)ImageView adv;

    @Override
    public void onCreate(Bundle SaveInstanceBundle){
        super.onCreate(SaveInstanceBundle);
        setContentView(R.layout.adviertisement_activity);
        ButterKnife.bind(this);
        mPersenter.LoadingAdv(adv);
    }

    @Override
    protected void initMvp() {
        DaggerAdvertisementComponent.builder().advertisementModule(new AdvertisementModule(this))
                                    .appComponent(HelpUtils.getInstance().getAppComponent())
                                    .build().inject(this);
    }

    @Override
    public void showAdv(Bitmap bitmap) {
        adv.setImageBitmap(bitmap);
    }
}
