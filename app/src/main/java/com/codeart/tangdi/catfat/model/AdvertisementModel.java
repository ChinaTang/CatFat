package com.codeart.tangdi.catfat.model;

import android.graphics.Bitmap;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.codeart.tangdi.catfat.model.impmodel.IadvertisementModel;
import com.codeart.tangdi.catfat.netrequest.NetURL;
import com.codeart.tangdi.catfat.netrequest.VolleyRequest;

/**
 * Created by Administrator on 2017/6/2.
 */

public class AdvertisementModel implements IadvertisementModel {

    private RequestQueue mRequestQueue;

    private VolleyRequest mVolleyRequest;

    private ImageRequest mImageRequest;

    public AdvertisementModel(RequestQueue requestQueue, VolleyRequest volleyRequest){
        mRequestQueue = requestQueue;
        mVolleyRequest = volleyRequest;
    }

    public void LoadAdvView(){
        mImageRequest = mVolleyRequest.LoadImage(NetURL.BANNER, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mRequestQueue.add(mImageRequest);
    }


}
