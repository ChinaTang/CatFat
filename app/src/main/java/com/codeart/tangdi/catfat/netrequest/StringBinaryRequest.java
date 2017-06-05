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
import java.util.Map;

/**
 * Created by tangdi on 6/5/17.
 */

public class StringBinaryRequest extends Request<byte[]> {

    private Response.Listener<byte[]> listener;
    private Map<String, String> request;

    public StringBinaryRequest(String url, Response.Listener<byte[]> listener,
                               Response.ErrorListener errorListener, Map<String, String> request) {
        super(Method.POST, url, errorListener);
        this.listener = listener;
        this.request = request;
    }

    public StringBinaryRequest(String url, Response.Listener<byte[]> listener,
                               Response.ErrorListener errorListener){
        super(Method.GET, url, errorListener);
        this.listener = listener;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        Log.d("", "");
        return request;
    }

    @Override
    protected Response<byte[]> parseNetworkResponse(NetworkResponse response) {

        return Response.success(response.data,
                HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(byte[] response) {
        listener.onResponse(response);
    }
}
