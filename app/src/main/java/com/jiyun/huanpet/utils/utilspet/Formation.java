package com.jiyun.huanpet.utils.utilspet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Created by Lenovo on 2017/12/14.
 */

public class Formation extends BitmapTransformation {
    public Formation(Context context) {
        super(context);
    }

    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        //进行绘制圆形Bitmap
        return getBitmap(toTransform);
    }
    public Bitmap getBitmap(Bitmap bitmap){
        if(bitmap==null)
            return null;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int min = Math.min(width, height);
        int x = (width-min)/2;
        int y = (height-min)/2;
        //是根据原Bitmap，以x,y开始，裁剪min宽，min高的Bitmap出来
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, x, y, min, min);
        //创建min宽，min高的一个透明的Bitmap对象
        Bitmap bitmap2 = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_4444);


        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setShader(new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        int R = min/2;
        canvas.drawCircle(R,R,R,paint);
        return bitmap2;
    }


    @Override
    public String getId() {
        return getClass().getSimpleName();
    }

}
