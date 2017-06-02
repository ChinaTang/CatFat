package com.codeart.tangdi.catfat.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/6/2.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle SaveInstance){
        super.onCreate(SaveInstance);
        initMvp();
    }

    protected abstract void initMvp();

}
