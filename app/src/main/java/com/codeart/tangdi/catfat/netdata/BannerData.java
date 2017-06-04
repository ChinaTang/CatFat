package com.codeart.tangdi.catfat.netdata;

/**
 * Created by tangdi on 6/2/17.
 */

public class BannerData {
    public int code;
    public String msg;
    public Data data;
    public BannerData(){
        data = new Data();
    }
    public class Data{
        public int resource_type;
        public String resource_url;
        public int loop_time;
        public String ads_url;
        public String title;
    }
}
