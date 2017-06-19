package com.codeart.tangdi.catfat.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.codeart.tangdi.catfat.model.impmodel.IadvertisementModel;
import com.codeart.tangdi.catfat.netdata.BannerData;
import com.codeart.tangdi.catfat.netrequest.NetURL;
import com.codeart.tangdi.catfat.netrequest.StringBinaryRequest;
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

    private StringJsonRequest stringJsonRequest;

    private StringBinaryRequest stringBinaryRequest;

    public AdvertisementModel(RequestQueue requestQueue, VolleyRequest volleyRequest){
        mRequestQueue = requestQueue;
        mVolleyRequest = volleyRequest;
    }

    @Override
    public void LoadAdvView(final LoadingImageResult loadingImageResult){

        final Map<String, String> request = new HashMap<>();
        request.put("scene", "101");
        request.put("location_type", "2");
        request.put("location_id", "340100");
        request.put("device", "1");


        stringJsonRequest = mVolleyRequest.StringJSONRequestGet(NetURL.BANNER, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                BannerData bannerData = new BannerData();
                try {
                    bannerData.code = response.getInt("code");
                    bannerData.msg = response.getString("msg");
                    JSONObject json = response.getJSONArray("data").getJSONObject(0);
                    bannerData.data.ads_url = json.getString("ads_url");
                    bannerData.data.loop_time = json.getInt("loop_time");
                    bannerData.data.resource_type = json.getInt("resource_type");
                    bannerData.data.resource_url = json.getString("resource_url");
                    bannerData.data.title = json.getString("title");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if(bannerData.data.resource_url != null){

                    stringBinaryRequest = mVolleyRequest.StringBinayRequestGet(bannerData.data.resource_url, new Response.Listener<byte[]>() {

                        @Override
                        public void onResponse(byte[] response) {
                            Bitmap bitmap = BitmapFactory.decodeByteArray(response, 0, response.length);
                            loadingImageResult.LoadingSuccess(bitmap);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                        }
                    }, null);
                    mRequestQueue.add(stringBinaryRequest);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loadingImageResult.LoadingFault(error.getMessage());
            }
        }, request);
        mRequestQueue.add(stringJsonRequest);
    }

    public interface LoadingImageResult{
        void LoadingSuccess(Bitmap bitmap);
        void LoadingFault(String msg);
    }

}
