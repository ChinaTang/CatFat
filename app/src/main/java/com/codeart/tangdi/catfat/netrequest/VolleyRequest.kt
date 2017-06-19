package com.codeart.tangdi.catfat.netrequest

import android.graphics.Bitmap
import android.widget.ImageView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject

/**
 * Created by Administrator on 2017/6/2.
 */

class VolleyRequest {

    fun LoadImage(url: String, listener: Response.Listener<Bitmap>, errorListener: Response.ErrorListener): ImageRequest {
        val imageRequest = ImageRequest(url, listener, 0, 0, ImageView.ScaleType.FIT_XY,
                Bitmap.Config.ARGB_8888, errorListener)
        return imageRequest
    }

    fun JSONRequestGet(url: String, jsonObject: JSONObject,
                       listener: Response.Listener<JSONObject>,
                       errorListener: Response.ErrorListener): JsonObjectRequest {
        return JsonObjectRequest(Request.Method.GET, url, null, listener, errorListener)
    }

    fun StringJSONRequestGet(url: String, listener: Response.Listener<JSONObject>,
                             errorListener: Response.ErrorListener, map: Map<String, String>): StringJsonRequest {
        val stringBuilder = StringBuilder(url)
        stringBuilder.append(getParam(map))
        return StringJsonRequest(stringBuilder.toString(), listener, errorListener)
    }

    fun StringJSONRequestPost(url: String,
                              listener: Response.Listener<JSONObject>,
                              errorListener: Response.ErrorListener, request: Map<String, String>): StringJsonRequest {
        return StringJsonRequest(Request.Method.POST, url, listener, errorListener, request)

    }

    private fun getParam(map: Map<String, String>?): String {
        if (map == null) {
            return ""
        }
        val stringBuilder = StringBuilder()
        stringBuilder.append("?")
        for ((key, value) in map) {
            stringBuilder.append(key)
            stringBuilder.append("=")
            stringBuilder.append(value)
            stringBuilder.append("&")
        }
        return stringBuilder.substring(0, stringBuilder.length - 1)
    }

    fun StringBinaryRequestPost(url: String, listener: Response.Listener<ByteArray>,
                                errorListener: Response.ErrorListener,
                                requset: Map<String, String>): StringBinaryRequest {
        return StringBinaryRequest(url, listener, errorListener, requset)
    }

    fun StringBinayRequestGet(url: String, listener: Response.Listener<ByteArray>,
                              errorListener: Response.ErrorListener,
                              requset: Map<String, String>?): StringBinaryRequest {
        val stringBuilder = StringBuilder(url)
        stringBuilder.append(getParam(requset))
        return StringBinaryRequest(url, listener, errorListener)

    }


}
