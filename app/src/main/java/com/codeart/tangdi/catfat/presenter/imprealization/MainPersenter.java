package com.codeart.tangdi.catfat.presenter.imprealization;

import com.codeart.tangdi.catfat.activity.impview.IMainView;
import com.codeart.tangdi.catfat.model.impmodel.IMainModel;
import com.codeart.tangdi.catfat.presenter.presenterinterface.IMainPersenter;

/**
 * Created by Administrator on 2017/6/14.
 */

public class MainPersenter implements IMainPersenter {

    private IMainView mView;

    private IMainModel mModel;

    public MainPersenter(IMainView mainView, IMainModel mainModel){
        this.mView = mainView;
        this.mModel = mainModel;
    }
}
