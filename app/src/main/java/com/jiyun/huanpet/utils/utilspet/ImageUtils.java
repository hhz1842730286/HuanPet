package com.jiyun.huanpet.utils.utilspet;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Lenovo on 2017/12/21.
 */

public class ImageUtils {
    public ImageUtils() {
    }

    public static Bitmap getMyBitmap(Context context, int resId, int w, int h) {
        Bitmap oldbmp = BitmapFactory.decodeResource(context.getResources(), resId);
        if(oldbmp != null) {
            int width = oldbmp.getWidth();
            int height = oldbmp.getHeight();
            Matrix matrix = new Matrix();
            float scaleWidth = (float)w / (float)width;
            float scaleHeight = (float)h / (float)height;
            matrix.postScale(scaleWidth, scaleHeight);
            Bitmap newbmp = Bitmap.createBitmap(oldbmp, 0, 0, width, height, matrix, true);
            return newbmp;
        } else {
            return null;
        }
    }

    public byte[] Bitmap2Bytes(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }

    public Bitmap Bytes2Bimap(byte[] b) {
        return b.length != 0?BitmapFactory.decodeByteArray(b, 0, b.length):null;
    }

//    public static Bitmap drawableToBitmap(Drawable drawable) {
//        int w = drawable.getIntrinsicWidth();
//        int h = drawable.getIntrinsicHeight();
//        Bitmap.Config config = drawable.getOpacity() != 1? Bitmap.Config.ARGB_8888: Bitmap.Config.RGB_565;
//        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
//        Canvas canvas = new Canvas(bitmap);
//        drawable.setBounds(0, 0, w, h);
//        drawable.draw(canvas);
//        return bitmap;
//    }

    public static Drawable bitmapToDrawable(Bitmap bitmap) {
        return new BitmapDrawable(bitmap);
    }

    public static Bitmap inputStreamToBitmap(InputStream inputStream) throws Exception {
        return BitmapFactory.decodeStream(inputStream);
    }

    public static Bitmap getImageViewBitmap(String path) throws IOException {
        InputStream inputStream = null;
        URL url = new URL(path);
        if(url != null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0");
            httpURLConnection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpURLConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
            httpURLConnection.setRequestProperty("Connection", "keep-alive");
            httpURLConnection.setRequestProperty("Cache-Control", "max-age=0");
            httpURLConnection.setRequestProperty("DNT", "1");
            int responseCode = httpURLConnection.getResponseCode();
            if(responseCode == 200) {
                inputStream = httpURLConnection.getInputStream();
            }
        }

        try {
            return inputStreamToBitmap(inputStream);
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public static Bitmap byteToBitmap(byte[] byteArray) {
        return byteArray.length != 0?BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length):null;
    }

    public static Drawable byteToDrawable(byte[] byteArray) {
        ByteArrayInputStream ins = null;
        if(byteArray != null) {
            ins = new ByteArrayInputStream(byteArray);
        }

        return Drawable.createFromStream(ins, (String)null);
    }

    public static byte[] bitmapToBytes(Bitmap bm) {
        byte[] bytes = null;
        if(bm != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
            bytes = baos.toByteArray();
        }

        return bytes;
    }

    public static byte[] drawableToBytes(Drawable drawable) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable)drawable;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        byte[] bytes = bitmapToBytes(bitmap);
        return bytes;
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Bitmap output = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        int color = -12434878;
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, w, h);
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    public static Bitmap zoomBitmap(Bitmap bitmap, int width, int height) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float scaleWidth = (float)width / (float)w;
        float scaleHeight = (float)height / (float)h;
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
        return newbmp;
    }

    public static Drawable zoomDrawable(Drawable drawable, int w, int h) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap oldbmp = drawableToBitmap(drawable);
        Matrix matrix = new Matrix();
        float sx = (float)w / (float)width;
        float sy = (float)h / (float)height;
        matrix.postScale(sx, sy);
        Bitmap newbmp = Bitmap.createBitmap(oldbmp, 0, 0, width, height, matrix, true);
        return new BitmapDrawable(newbmp);
    }

    private static Bitmap drawableToBitmap(Drawable drawable) {
        return null;
    }

    public static Bitmap getPhotoFromSDCard(String path, String photoName) {
        Bitmap photoBitmap = BitmapFactory.decodeFile(path + "/" + photoName + ".png");
        return photoBitmap == null?null:photoBitmap;
    }

    public static boolean checkSDCardAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean findPhotoFromSDCard(String path, String photoName) {
        boolean flag = false;
        if(checkSDCardAvailable()) {
            File dir = new File(path);
            if(dir.exists()) {
                File folders = new File(path);
                File[] photoFile = folders.listFiles();

                for(int i = 0; i < photoFile.length; ++i) {
                    String fileName = photoFile[i].getName().split("\\.")[0];
                    if(fileName.equals(photoName)) {
                        flag = true;
                    }
                }
            } else {
                flag = false;
            }
        } else {
            flag = false;
        }

        return flag;
    }

    public static void savePhotoToSDCard(Bitmap photoBitmap, String path, String photoName) {
        if(checkSDCardAvailable()) {
            File dir = new File(path);
            if(!dir.exists()) {
                dir.mkdirs();
            }

            File photoFile = new File(path, photoName);
            FileOutputStream fileOutputStream = null;

            try {
                fileOutputStream = new FileOutputStream(photoFile);
                if(photoBitmap != null && photoBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)) {
                    fileOutputStream.flush();
                }

                fileOutputStream.flush();
            } catch (FileNotFoundException var17) {
                photoFile.delete();
                var17.printStackTrace();
            } catch (IOException var18) {
                photoFile.delete();
                var18.printStackTrace();
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException var16) {
                    var16.printStackTrace();
                }

            }
        }

    }

    public static Uri file2Content(Uri uri, Context context) {
        if(uri.getScheme().equals("file")) {
            String path = uri.getEncodedPath();
            if(path != null) {
                path = Uri.decode(path);
                ContentResolver cr = context.getContentResolver();
                StringBuffer buff = new StringBuffer();
                buff.append("(").append("_data").append("=").append("'" + path + "'").append(")");
                Cursor cur = cr.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, buff.toString(), (String[])null, (String)null);
                int index = 0;
                cur.moveToFirst();

                while(!cur.isAfterLast()) {
                    index = cur.getColumnIndex("_id");
                    index = cur.getInt(index);
                    cur.moveToNext();
                }

                if(index != 0) {
                    Uri uri_temp = Uri.parse("content://media/external/images/media/" + index);
                    if(uri_temp != null) {
                        uri = uri_temp;
                    }
                }
            }
        }

        Log.e("dddd", "========uri==========" + uri);
        return uri;
    }

    public static void deleteAllPhoto(String path) {
        if(checkSDCardAvailable()) {
            File folder = new File(path);
            File[] files = folder.listFiles();

            for(int i = 0; i < files.length; ++i) {
                files[i].delete();
            }
        }

    }

    public static void deleteAllHuanHuanPhoto() {
        File folder = new File(Environment.getExternalStorageDirectory() + File.separator + "HuanHuan");
        File[] files = folder.listFiles();
        if(files != null) {
            for(int i = 0; i < files.length; ++i) {
                files[i].delete();
            }
        }

    }

    public static void deletePhotoAtPathAndName(String path, String fileName) {
        if(checkSDCardAvailable()) {
            File folder = new File(path);
            File[] files = folder.listFiles();

            for(int i = 0; i < files.length; ++i) {
                if(files[i].getName().split("\\.")[0].equals(fileName)) {
                    files[i].delete();
                }
            }
        }

    }

    public static byte[] UrltoByte(String url) {
        byte[] result = null;
        ByteArrayOutputStream bos = null;

        try {
            new URI(url);
            HttpURLConnection conn = (HttpURLConnection)(new URL(url)).openConnection();
            InputStream is = conn.getInputStream();
            bos = new ByteArrayOutputStream();
//           int len = true;
            byte[] b = new byte[1024];

            int len;
            while((len = is.read(b)) != -1) {
                bos.write(b, 0, len);
            }

            result = bos.toByteArray();
        } catch (MalformedURLException var8) {
            var8.printStackTrace();
        } catch (URISyntaxException var9) {
            var9.printStackTrace();
        } catch (IOException var10) {
            var10.printStackTrace();
        }

        return result;
    }
}
