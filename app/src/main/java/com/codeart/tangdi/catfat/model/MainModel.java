package com.codeart.tangdi.catfat.model;

import com.android.volley.RequestQueue;
import com.codeart.tangdi.catfat.model.impmodel.IMainModel;
import com.codeart.tangdi.catfat.netrequest.VolleyRequest;

/**
 * Created by Administrator on 2017/6/14.
 */

public class MainModel implements IMainModel {
    private RequestQueue mRequestQueue;
    private VolleyRequest mVolleyRequest;

    public MainModel(RequestQueue requestQueue, VolleyRequest volleyRequest){
        this.mRequestQueue = requestQueue;
        this.mVolleyRequest = volleyRequest;
    }
}
