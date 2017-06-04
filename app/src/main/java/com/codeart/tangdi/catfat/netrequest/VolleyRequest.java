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

    public JsonObjectRequest JSONRequestGet(String url, JSONObject jsonObject, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener){
        return new JsonObjectRequest(Request.Method.GET, url, null, listener, errorListener);
    }

    public StringJsonRequest JSONRequestGet(int method, String url, Response.Listener<JSONObject> listener,
                                            Response.ErrorListener errorListener, Map<String, String> map){
        return new StringJsonRequest(method, url, listener, errorListener, map);
    }

}
