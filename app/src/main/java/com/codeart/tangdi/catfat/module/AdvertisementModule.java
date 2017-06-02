package com.codeart.tangdi.catfat.module;

import com.codeart.tangdi.catfat.activity.impview.IadvertisementView;
import com.codeart.tangdi.catfat.annotation.ActivityScope;
import com.codeart.tangdi.catfat.model.AdvertisementModel;
import com.codeart.tangdi.catfat.model.impmodel.IadvertisementModel;
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
    public IadvertisementModel provideAdvertisementModel(){
        return new AdvertisementModel();
    }

    @ActivityScope
    @Provides
    public IAdvertisementPersenter provideAdvertisementPresenter(IadvertisementView view, IadvertisementModel model){
        return new AdvertisementPresenter(model, view);
    }

}
