package com.codeart.tangdi.catfat.module;

import com.android.volley.RequestQueue;
import com.codeart.tangdi.catfat.activity.impview.IadvertisementView;
import com.codeart.tangdi.catfat.annotation.ActivityScope;
import com.codeart.tangdi.catfat.model.AdvertisementModel;
import com.codeart.tangdi.catfat.model.impmodel.IadvertisementModel;
import com.codeart.tangdi.catfat.netrequest.VolleyRequest;
import com.codeart.tangdi.catfat.presenter.imprealization.AdvertisementPresenter;
import com.codeart.tangdi.catfat.presenter.presenterinterface.IAdvertisementPersenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/6/2.
 */

@Module
public class AdvertisementModule {

    private IadvertisementView mView;

    public AdvertisementModule(IadvertisementView view){
        mView = view;
    }

    @ActivityScope
    @Provides
    public IadvertisementView provideAdvertisementView(){
        return this.mView;
    }

    @ActivityScope
    @Provides
    public IadvertisementModel provideAdvertisementModel(RequestQueue requestQueue, VolleyRequest volleyRequest){
        return new AdvertisementModel(requestQueue, volleyRequest);
    }

    @ActivityScope
    @Provides
    public IAdvertisementPersenter provideAdvertisementPresenter(IadvertisementView view, IadvertisementModel model){
        return new AdvertisementPresenter(model, view);
    }

}
