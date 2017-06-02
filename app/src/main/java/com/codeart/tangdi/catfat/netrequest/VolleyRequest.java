package com.codeart.tangdi.catfat.netrequest;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;

/**
 * Created by Administrator on 2017/6/2.
 */

public class VolleyRequest {

    public ImageRequest LoadImage(String url, Response.Listener<Bitmap> listener, Response.ErrorListener errorListener){
        ImageRequest imageRequest = new ImageRequest(url, listener, 0, 0, ImageView.ScaleType.FIT_XY,
                                                     Bitmap.Config.ARGB_8888, errorListener);
        return imageRequest;
    }

}
