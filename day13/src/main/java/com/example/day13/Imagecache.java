package com.example.day13;

import android.graphics.Bitmap;
import android.util.LruCache;

public class Imagecache {
    private final LruCache<String, Bitmap> lruCache;

    public Imagecache(){
        long maxMemory = Runtime.getRuntime().maxMemory();
        int size1 = (int) (maxMemory/4)/1024;
        lruCache=new LruCache<String,Bitmap>(size1){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()*value.getHeight()/1024;
            }
        };
    }
    public void put(String url,Bitmap bitmap){
        lruCache.put(url,bitmap);
    }
    public Bitmap getBitmap(String url){
        return lruCache.get(url);
    }

}
