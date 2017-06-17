package com.codeart.tangdi.catfat.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.codeart.tangdi.catfat.R;
import com.codeart.tangdi.catfat.activity.impview.IadvertisementView;
import com.codeart.tangdi.catfat.base.BaseActivity;
import com.codeart.tangdi.catfat.component.DaggerAdvertisementComponent;
import com.codeart.tangdi.catfat.daggerhelp.HelpUtils;
import com.codeart.tangdi.catfat.module.AdvertisementModule;
import com.codeart.tangdi.catfat.presenter.presenterinterface.IAdvertisementPersenter;

import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/6/2.
 */

public class AdvertisementActivity extends BaseActivity implements IadvertisementView {

    @Inject
    IAdvertisementPersenter mPersenter;


    //@BindView(R.id.adv)ImageView adv;
    //@BindView(R.id.jump_adv)TextView jump_adv;

    private TextView jump_adv;

    private ImageView adv;

    private int count = 5;

    private Timer mTimer;

    private TimerTask mTimerTask = new TimerTask(){
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    jump_adv.setText("跳过(" + count + ")");
                }
            });
            if(count == 0){
                jumpActivity();
            }
            count--;
        }
    };

    @Override
    public void onCreate(Bundle SaveInstanceBundle){
        super.onCreate(SaveInstanceBundle);
        setContentView(R.layout.adviertisement_activity);
        initDate();
        //ButterKnife.bind(this);
        jump_adv = (TextView)findViewById(R.id.jump_adv);
        adv = (ImageView)findViewById(R.id.adv);
        mPersenter.LoadingAdv(adv);
        jump_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpActivity();
            }
        });
    }

    private void initDate(){
        mTimer = new Timer();
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
        mTimer.schedule(mTimerTask, 0, 1000);
    }

    private void jumpActivity(){
        mTimer.cancel();
        Intent intent = new Intent(AdvertisementActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
