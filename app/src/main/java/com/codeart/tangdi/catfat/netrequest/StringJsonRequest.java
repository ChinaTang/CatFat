package com.codeart.tangdi.catfat.netrequest;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by tangdi on 6/4/17.
 */

public class StringJsonRequest extends Request<JSONObject> {

    private Response.Listener<JSONObject> mListener;

    private Map<String, String> mMap;


    public StringJsonRequest(int method, String url, Response.Listener<JSONObject> listener,
                             Response.ErrorListener errorListener, Map<String, String> map) {
        super(method, url, errorListener);
        mListener = listener;
        mMap = map;
    }


    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        Log.d("", "");
       return mMap;
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {

        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(new JSONObject(jsonString),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }
    }


    @Override
    protected void deliverResponse(JSONObject response) {
        mListener.onResponse(response);
    }
}
