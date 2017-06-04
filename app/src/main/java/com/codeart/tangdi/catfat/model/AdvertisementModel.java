package com.codeart.tangdi.catfat.model;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Scroller;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.codeart.tangdi.catfat.model.impmodel.IadvertisementModel;
import com.codeart.tangdi.catfat.netdata.BannerData;
import com.codeart.tangdi.catfat.netrequest.NetURL;
import com.codeart.tangdi.catfat.netrequest.StringJsonRequest;
import com.codeart.tangdi.catfat.netrequest.VolleyRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/2.
 */

public class AdvertisementModel implements IadvertisementModel {

    private RequestQueue mRequestQueue;

    private VolleyRequest mVolleyRequest;

    private ImageRequest mImageRequest;

    private JsonObjectRequest jsonObjectRequest;

    private StringJsonRequest stringJsonRequest;

    public AdvertisementModel(RequestQueue requestQueue, VolleyRequest volleyRequest){
        mRequestQueue = requestQueue;
        mVolleyRequest = volleyRequest;
    }

    @Override
    public void LoadAdvView(final LoadingImageResult loadingImageResult){

        Map<String, String> request = new HashMap<>();
        request.put("scene", "101");
        request.put("location_type", "2");
        request.put("location_id", "340100");
        request.put("device", "1");

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("scene", "101");
            jsonObject.put("location_type", "2");
            jsonObject.put("location_id", "340100");
            jsonObject.put("device", "1");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        stringJsonRequest = mVolleyRequest.JSONRequestGet(Request.Method.GET, NetURL.BANNER, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                BannerData bannerData = new BannerData();
                try {
                    bannerData.code = response.getInt("code");
                    bannerData.msg = response.getString("msg");
                    JSONObject json = response.getJSONObject("data");
                    bannerData.data.ads_url = response.getString("ads_url");
                    bannerData.data.loop_time = response.getInt("loop_time");
                    bannerData.data.resource_type = response.getInt("resource_type");
                    bannerData.data.resource_url = response.getString("resource_url");
                    bannerData.data.title = response.getString("title");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if(bannerData.data.resource_url != null){
                    mImageRequest = mVolleyRequest.LoadImage(NetURL.BANNER, new Response.Listener<Bitmap>() {
                        @Override
                        public void onResponse(Bitmap response) {
                            loadingImageResult.LoadingSuccess(response);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            loadingImageResult.LoadingFault(error.getMessage());
                        }
                    });
                    mRequestQueue.add(mImageRequest);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("", "");
            }
        }, request);
        mRequestQueue.add(stringJsonRequest);
    }

    public interface LoadingImageResult{
        void LoadingSuccess(Bitmap bitmap);
        void LoadingFault(String msg);
    }

}
