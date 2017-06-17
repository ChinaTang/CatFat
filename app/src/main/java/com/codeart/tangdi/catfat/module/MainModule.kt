package com.codeart.tangdi.catfat.module

import com.android.volley.RequestQueue
import com.codeart.tangdi.catfat.activity.impview.IMainView
import com.codeart.tangdi.catfat.annotation.ActivityScope
import com.codeart.tangdi.catfat.model.MainActivityModel
import com.codeart.tangdi.catfat.model.impmodel.IMainModel
import com.codeart.tangdi.catfat.netrequest.VolleyRequest
import com.codeart.tangdi.catfat.presenter.imprealization.MainPresenter
import com.codeart.tangdi.catfat.presenter.presenterinterface.IMainPersenter
import dagger.Module
import dagger.Provides

/**
 * Created by tangdi on 6/17/17.
 */
@Module
class MainModule (val mView: IMainView){

    @ActivityScope
    @Provides
    fun provideView(): IMainView = mView

    @ActivityScope
    @Provides
    fun provideModle(requestQueue: RequestQueue, volleyRequest: VolleyRequest): IMainModel
            = MainActivityModel(requestQueue, volleyRequest)

    @ActivityScope
    @Provides
    fun providePersent(view: IMainView, model: IMainModel): IMainPersenter
            = MainPresenter(model, view)
}