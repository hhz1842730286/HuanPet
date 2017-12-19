package com.jiyun.huanpet.utils.utilspet;

/*
 *  String imageUri = "http://site.com/image.png"; // 网络图片  
 String imageUri = "file:///mnt/sdcard/image.png"; //SD卡图�???  
 String imageUri = "content://media/external/audio/albumart/13"; // 媒体文件�???  
 String imageUri = "assets://image.png"; // assets  
 String imageUri = "drawable://" + R.drawable.image; //  drawable文件   
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jiyun.huanpet.R;
import com.jiyun.huanpet.config.Urls;
import com.jiyun.huanpet.httputils.AppUtils;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * 
 * @描述 : 网络访问缓存
 * @类名 : HttpCacheUtils
 * @作�?? : Android - yhq
 * @版本 : v1.0
 * @日期 : 2016�???4�???7�???
 */
public class HttpCacheUtils {
	public static DisplayImageOptions getImageOptions(int resId) {
		BitmapFactory.Options decodeOptions = new BitmapFactory.Options();
		decodeOptions.inSampleSize = 2;
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.showImageOnLoading(resId)
				// 设置图片在下载期间显示的图片
				.showImageForEmptyUri(resId)
				// 设置图片Uri为空或是错误的时候显示的图片
				.showImageOnFail(resId)
				// 设置图片加载/解码过程中错误时候显示的图片
				.cacheOnDisc(true).decodingOptions(decodeOptions)
				.bitmapConfig(Bitmap.Config.RGB_565)// 设置下载的图片是否缓存在SD卡中
				.build();// 构建完成
		return options;
	}

	/**
	 *
	 * @描述 : 设置缓存图片
	 * @方法名称 : loadImage---->HttpCacheUtils.java
	 * @作�?? : Android - yhq
	 * @创建日期 : 2016�???4�???7�??? 上午11:36:16
	 * @param url
	 * @param view
	 */
	public static void loadImage(String url, ImageView view) {
		try {
			if (url.indexOf("http://") != -1 || url.indexOf("https://") != -1) {
				ImageLoader.getInstance().displayImage(url, view,
						getImageOptions(R.mipmap.ic_launcher));
			} else {
				ImageLoader.getInstance().displayImage(
						Urls.HTTP_IMAGE_URL + url, view,
						getImageOptions(R.mipmap.ic_launcher));
			}
		} catch (Exception e) {
			Glide.with(AppUtils.getAppContext())
					.load(R.mipmap.ic_launcher).into(view);
		}
	}

	/**
	 *
	 * @描述 : 加载全路径图�???
	 * @方法名称 : loadImage---->HttpCacheUtils.java
	 * @作�?? : Android - yhq
	 * @创建日期 : 2016�???4�???7�??? 上午11:36:16
	 * @param url
	 * @param view
	 */
	public static void loadImageAllPathHttp(String url, ImageView view) {
		try {
			if (url.indexOf("http://") != -1 || url.indexOf("https://") != -1) {
				ImageLoader.getInstance().displayImage(url, view,
						getImageOptions(R.mipmap.ic_launcher));
			} else {
				ImageLoader.getInstance().displayImage(url, view,
						getImageOptions(R.mipmap.ic_launcher));
			}
		} catch (Exception e) {
			Glide.with(AppUtils.getAppContext())
					.load(R.mipmap.ic_launcher).into(view);
		}
	}

	/**
	 *
	 * @描述 : 设置缓存图片
	 * @方法名称 : loadImage---->HttpCacheUtils.java
	 * @作�?? : Android - yhq
	 * @创建日期 : 2016�???4�???7�??? 上午11:36:16
	 * @param url
	 * @param view
	 */
	public static void loadImagePet(String url, ImageView view) {
		try {
			if (url.indexOf("http://") != -1 || url.indexOf("https://") != -1) {
				ImageLoader.getInstance().displayImage(url, view,
						getImageOptions(com.jiyun.huanpet.R.mipmap.ic_launcher));
			} else {
				ImageLoader.getInstance().displayImage(
						Urls.HTTP_IMAGE_URL + url, view,
						getImageOptions(R.mipmap.ic_launcher));
			}
		} catch (Exception e) {
			Glide.with(AppUtils.getAppContext()).load(R.mipmap.ic_launcher)
					.into(view);
		}
	}

	/**
	 *
	 * @描述 : 设置缓存图片
	 * @方法名称 : loadImage---->HttpCacheUtils.java
	 * @作�?? : Android - yhq
	 * @创建日期 : 2016�???4�???7�??? 上午11:36:16
	 * @param url
	 * @param view
	 */
	public static void loadFilePetImage(String url, ImageView view) {
		try {
			if (url.indexOf("http://") != -1 || url.indexOf("https://") != -1) {
				ImageLoader.getInstance().displayImage(url, view,
						getImageOptions(R.mipmap.ic_launcher));
			} else {
				ImageLoader.getInstance().displayImage("file://" + url, view,
						getImageOptions(R.mipmap.ic_launcher));
			}
		} catch (Exception e) {
			Glide.with(AppUtils.getAppContext()).load(R.mipmap.ic_launcher)
					.into(view);
		}
	}

	/**
	 *
	 * @描述 : 设置缓存图片
	 * @方法名称 : loadImage---->HttpCacheUtils.java
	 * @作�?? : Android - yhq
	 * @创建日期 : 2016�???4�???7�??? 上午11:36:16
	 * @param url
	 * @param view
	 */
	@SuppressWarnings("deprecation")
	public static void loadImageUser(String url, ImageView view) {
		try {
			if (url.indexOf("http://") != -1 || url.indexOf("https://") != -1) {
				ImageLoader.getInstance().displayImage(url, view,
						getImageOptions(R.mipmap.user_defaults));
			} else {
				ImageLoader.getInstance().displayImage(
						Urls.HTTP_IMAGE_URL + url, view,
						getImageOptions(R.mipmap.user_defaults));
			}
		} catch (Exception e) {
			Glide.with(AppUtils.getAppContext())
					.load(R.mipmap.user_defaults).into(view);
		}
	}

	/**
	 * 获取缓存大小
	 *
	 * @return
	 */
//	public static String getCacheSize() {
//		DiskCache diskCache = (DiskCache) ImageLoader.getInstance().getDiscCache();
//		File file = diskCache.get();
//		return FileSizeUtil.getAutoFileOrFilesSize(file.getPath());
//	}

	/**
	 * 清理缓存
	 */
	public static void clearCache() {
		ImageLoader.getInstance().getDiscCache().clear();
		ImageLoader.getInstance().getMemoryCache().clear();
		ACache.getInstance().clear();
	}

}
