package edu.feicui.app.phone.util;

import android.graphics.Bitmap;

import java.lang.ref.ReferenceQueue;

/**
 * Created by Administrator on 2016/7/6.
 */
public class SoftReference extends java.lang.ref.SoftReference<Bitmap> {
    private Integer _key=0;
    public SoftReference(Bitmap r) {
        super(r);
    }

    public SoftReference(Bitmap r, ReferenceQueue<? super Bitmap> q) {
        super(r, q);
    }
}
