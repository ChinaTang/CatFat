package com.codeart.tangdi.catfat.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.codeart.tangdi.catfat.R
import com.codeart.tangdi.catfat.activity.impview.IMainView
import com.codeart.tangdi.catfat.component.DaggerMainComponent
import com.codeart.tangdi.catfat.daggerhelp.HelpUtils
import com.codeart.tangdi.catfat.module.MainModule
import com.codeart.tangdi.catfat.presenter.presenterinterface.IMainPersenter
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * Created by Administrator on 2017/6/14.
 */

class MainActivity : AppCompatActivity(), IMainView {


    @Inject
    lateinit var persenter: IMainPersenter

    public override fun onCreate(saveInstanceBundle: Bundle?) {
        super.onCreate(saveInstanceBundle)
        setContentView(R.layout.activity_main)
        initMvp()
        if(persenter == null){

        }else{

        }
    }

    private fun initMvp(){
        DaggerMainComponent
                .builder()
                .mainModule(MainModule(this))
                .appComponent(HelpUtils.getInstance().appComponent)
                .build().inject(this)
    }
}
