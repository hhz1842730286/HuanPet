package com.jiyun.huanpet.utils.utilspet;

import android.content.Context;
import android.util.Log;

import com.jiyun.huanpet.httputils.CJSON;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Lenovo on 2017/12/21.
 */

public class UploadUtil {
    private static final String TAG = "uploadFile";
    private static final int TIME_OUT = 10000;
    private static final String CHARSET = "utf-8";
    private static Context CONTEXT = null;


    public UploadUtil() {
    }

    public static void init(Context context) {
        CONTEXT = context;
    }

    public static String uploadFile(File file, String RequestURL, String json) {
        String result = null;
        String BOUNDARY = UUID.randomUUID().toString();
        String PREFIX = "--";
        String LINE_END = "\r\n";
        String CONTENT_TYPE = "multipart/form-data";

        try {
            URL url = new URL(RequestURL);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(10000);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("contentType", "utf-8");
            conn.setRequestProperty("connection", "keep-alive");
            conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);
            if(file != null) {
                DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
                StringBuffer sb = new StringBuffer();
                sb.append(PREFIX);
                sb.append(BOUNDARY);
                sb.append(LINE_END);
                sb.append("Content-Disposition: form-data; name=" + json + ";filename=\"" + file.getName() + "\"" + LINE_END);
                sb.append("Content-Type: application/octet-stream; charset=utf-8" + LINE_END);
                sb.append(LINE_END);
                dos.write(sb.toString().getBytes());
                InputStream is = new FileInputStream(file);
                byte[] bytes = new byte[1024];
                boolean var14 = false;

                int len;
                while((len = is.read(bytes)) != -1) {
                    dos.write(bytes, 0, len);
                }

                Log.e("CXP", "==" + sb);
                is.close();
                dos.write(LINE_END.getBytes());
                byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes();
                dos.write(end_data);
                dos.flush();
                int res = conn.getResponseCode();
                InputStream input = conn.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(input, "utf-8"));
                StringBuffer sb1 = new StringBuffer();
                String line = "";

                while((line = in.readLine()) != null) {
                    sb1.append(line);
                }

                result = sb1.toString();
                ImageUtils.deleteAllHuanHuanPhoto();
            }
        } catch (MalformedURLException var21) {
            var21.printStackTrace();
        } catch (IOException var22) {
            var22.printStackTrace();
        }

        return result;
    }

    public static String uploadFile(Map<String, File> files, String RequestURL, Map<String, Object> params) {
        String result = null;
        String BOUNDARY = UUID.randomUUID().toString();
        String PREFIX = "--";
        String LINE_END = "\r\n";
        String CONTENT_TYPE = "multipart/form-data";

        try {
            URL url = new URL(RequestURL);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(10000);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("contentType", "utf-8");
            conn.setRequestProperty("connection", "keep-alive");
            conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);
            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            Iterator var12 = files.entrySet().iterator();

            while(var12.hasNext()) {
                Map.Entry<String, File> file = (Map.Entry)var12.next();
                StringBuffer sb = new StringBuffer();
                sb.append(PREFIX);
                sb.append(BOUNDARY);
                sb.append(LINE_END);
                sb.append("Content-Disposition: form-data;name=\"" + (String)file.getKey() + "\"; filename=\"" + ((File)file.getValue()).getName() + "\"" + LINE_END);
                sb.append("Content-Type: application/octet-stream; charset=utf-8" + LINE_END);
                sb.append(LINE_END);
                dos.write(sb.toString().getBytes());
                InputStream is = new FileInputStream((File)file.getValue());
                byte[] bytes = new byte[1024];
                boolean var16 = false;

                int len;
                while((len = is.read(bytes)) != -1) {
                    dos.write(bytes, 0, len);
                }

                is.close();
                dos.write(LINE_END.getBytes());
                Log.e("CXP", "======update_pet====" + sb.toString());
            }

            StringBuilder sb1 = new StringBuilder();
            Iterator var23 = params.entrySet().iterator();

            while(var23.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry)var23.next();
                String json = CJSON.toJSONEntity(params.get(entry.getKey()));
                sb1.append(PREFIX);
                sb1.append(BOUNDARY);
                sb1.append(LINE_END);
                sb1.append("Content-Disposition: form-data; name=\"" + json + "\"" + LINE_END);
                sb1.append("Content-Type: text/plain; charset=utf-8" + LINE_END);
                sb1.append("Content-Transfer-Encoding: 8bit" + LINE_END);
                sb1.append(LINE_END);
                sb1.append(LINE_END);
            }

            Log.e("CXP", "======update_pet====" + sb1.toString());
            dos.write(sb1.toString().getBytes());
            byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes();
            dos.write(end_data);
            dos.flush();
            StringBuilder sb3 = new StringBuilder();
            int res = conn.getResponseCode();
            InputStream input = conn.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(input, "utf-8"));
            String line = "";

            while((line = in.readLine()) != null) {
                sb3.append(line);
            }

            result = sb3.toString();
            ImageUtils.deleteAllHuanHuanPhoto();
        } catch (MalformedURLException var18) {
            var18.printStackTrace();
        } catch (IOException var19) {
            var19.printStackTrace();
        }

        return result;
    }
}
