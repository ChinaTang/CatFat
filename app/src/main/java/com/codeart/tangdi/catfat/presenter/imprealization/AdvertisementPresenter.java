package com.codeart.tangdi.catfat.presenter.imprealization;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.codeart.tangdi.catfat.activity.impview.IadvertisementView;
import com.codeart.tangdi.catfat.model.AdvertisementModel;
import com.codeart.tangdi.catfat.model.impmodel.IadvertisementModel;
import com.codeart.tangdi.catfat.presenter.presenterinterface.IAdvertisementPersenter;

/**
 * Created by Administrator on 2017/6/2.
 */

public class AdvertisementPresenter implements IAdvertisementPersenter , AdvertisementModel.LoadingImageResult{

    private IadvertisementModel mModel;

    private IadvertisementView mView;

    public AdvertisementPresenter(IadvertisementModel model, IadvertisementView view){
        mView = view;
        mModel = model;
    }

    @Override
    public void LoadingAdv(ImageView imageView) {
        mModel.LoadAdvView(this);
    }

    @Override
    public void LoadingSuccess(Bitmap bitmap) {
        mView.showAdv(bitmap);
    }

    @Override
    public void LoadingFault(String msg) {

    }
}
