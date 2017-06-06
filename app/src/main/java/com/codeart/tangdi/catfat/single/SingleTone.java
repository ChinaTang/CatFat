package com.codeart.tangdi.catfat.single;

/**
 * Created by Administrator on 2017/6/6.
 */

public class SingleTone {
    private SingleTone(){}

    public static SingleTone getInstance(){
        return SingleToneHolder.sInstance;
    }

    private static class SingleToneHolder{
        private static final SingleTone sInstance = new SingleTone();
    }

}
