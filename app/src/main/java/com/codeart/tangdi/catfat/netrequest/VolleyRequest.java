package com.codeart.tangdi.catfat.netrequest;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2017/6/2.
 */

public class VolleyRequest {

    public ImageRequest LoadImage(String url, Response.Listener<Bitmap> listener, Response.ErrorListener errorListener){
        ImageRequest imageRequest = new ImageRequest(url, listener, 0, 0, ImageView.ScaleType.FIT_XY,
                                                     Bitmap.Config.ARGB_8888, errorListener);
        return imageRequest;
    }

    public JsonObjectRequest JSONRequestGet(String url, JSONObject jsonObject,
                                            Response.Listener<JSONObject> listener,
                                            Response.ErrorListener errorListener){
        return new JsonObjectRequest(Request.Method.GET, url, null, listener, errorListener);
    }

    public StringJsonRequest StringJSONRequestGet(String url, Response.Listener<JSONObject> listener,
                                            Response.ErrorListener errorListener, Map<String, String> map){
        StringBuilder stringBuilder = new StringBuilder(url);
        stringBuilder.append(getParam(map));
        return new StringJsonRequest(stringBuilder.toString(), listener, errorListener);
    }

    public StringJsonRequest StringJSONRequestPost(String url,
                                                   Response.Listener<JSONObject> listener,
                                                   Response.ErrorListener errorListener, Map<String, String> request){
        return new StringJsonRequest(Request.Method.POST, url, listener, errorListener, request);

    }

        private String getParam(Map<String, String> map){
            if(map == null){
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("?");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                stringBuilder.append(entry.getKey());
                stringBuilder.append("=");
                stringBuilder.append(entry.getValue());
                stringBuilder.append("&");
            }
            return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    public StringBinaryRequest StringBinaryRequestPost(String url, Response.Listener<byte[]> listener,
                                                      Response.ErrorListener errorListener,
                                                      Map<String, String> requset){
        return new StringBinaryRequest(url, listener, errorListener, requset);
    }

    public StringBinaryRequest StringBinayRequestGet(String url, Response.Listener<byte[]> listener,
                                                     Response.ErrorListener errorListener,
                                                     Map<String, String> requset){
        StringBuilder stringBuilder = new StringBuilder(url);
        stringBuilder.append(getParam(requset));
        return new StringBinaryRequest(url, listener, errorListener);

    }



}
