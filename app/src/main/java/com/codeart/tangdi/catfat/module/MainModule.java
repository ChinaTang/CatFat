package com.codeart.tangdi.catfat.module;

import com.android.volley.RequestQueue;
import com.codeart.tangdi.catfat.activity.impview.IMainView;
import com.codeart.tangdi.catfat.annotation.ActivityScope;
import com.codeart.tangdi.catfat.model.MainModel;
import com.codeart.tangdi.catfat.model.impmodel.IMainModel;
import com.codeart.tangdi.catfat.netrequest.VolleyRequest;
import com.codeart.tangdi.catfat.presenter.imprealization.MainPersenter;
import com.codeart.tangdi.catfat.presenter.presenterinterface.IMainPersenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/6/14.
 */

@Module
public class MainModule {
    private IMainView mView;

    public MainModule(IMainView view){
        mView = view;
    }

    @ActivityScope
    @Provides
    public IMainView provideView(){
        return this.mView;
    }

    @ActivityScope
    @Provides
    public IMainModel provideModel(RequestQueue requestQueue, VolleyRequest volleyRequest){
        return new MainModel(requestQueue, volleyRequest);
    }

    @ActivityScope
    @Provides
    public IMainPersenter providePersenter(IMainView mainView, IMainModel mainModel){
        return new MainPersenter(mainView, mainModel);
    }
}
