package com.hackathon.bhamashah.base;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by himanshukumarsingh on 19/02/17.
 */

public class GlideConfiguration implements GlideModule {
    private int sizeInBytes=10*1048576; //10 MB Cache size

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        // Apply options to the builder here.
        builder.setMemoryCache(new LruResourceCache(sizeInBytes));
        builder.setBitmapPool(new LruBitmapPool(sizeInBytes));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        // register ModelLoaders here.
    }
}
