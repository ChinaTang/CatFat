package com.codeart.tangdi.catfat.model

import com.android.volley.RequestQueue
import com.codeart.tangdi.catfat.model.impmodel.IMainModel
import com.codeart.tangdi.catfat.netrequest.VolleyRequest

/**
 * Created by tangdi on 6/17/17.
 */

class MainActivityModel(val request: RequestQueue, val volleyRequest: VolleyRequest): IMainModel{

}