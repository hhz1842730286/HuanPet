package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.codbking.widget.DatePickDialog;
import com.codbking.widget.bean.DateType;
import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.contract.PersonalInfomationContract;
import com.jiyun.huanpet.presenter.presenter.PersonalInfomationPresenterImpl;
import com.jiyun.huanpet.ui.base.BaseActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

import static android.R.attr.x;
import static com.jiyun.huanpet.constants.Constants.REQUESTCODE;

/**
 * Created by mengYao on 2017/12/11.
 */

public class PersonalInfomationActivity extends BaseActivity<PersonalInfomationPresenterImpl> implements PersonalInfomationContract.PersonalInfomationView, View.OnClickListener {
    private Context mCon;
    private static final int CAMERA_CODE = 1;
    private static final int GALLERY_CODE = 2;
    private static final int CROP_CODE = 3;
    private ImageView personal_return;
    private RelativeLayout head_portrait;
    private RelativeLayout mPersonalUserName;
    private RelativeLayout mPersonalSex;
    private RelativeLayout mDataOfBirth;
    private RelativeLayout mPersonalPhone;
    private RelativeLayout mPersonalWx;
    private RelativeLayout mPersonalQq;
    private RelativeLayout mContractAddress;
    private final int requestCode = 100;
    private TextView photograph;
    private TextView album;
    private TextView cancel;
    private LinearLayout person_lineartitle;
    private PopupWindow titlepopuwin;
    private ImageView person_titleimage;
    private TextView man;
    private TextView women;
    private PopupWindow sexPopuwin;
    private TextView determine;
    private TextView cancel1;
    private DatePicker datePicker;
    private PopupWindow timewindow;
    private StringBuffer lend_time;
    private SharedPreferences preferences;
    private SharedPreferences.Editor edit;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_infomation;
    }

    @Override
    protected void findViewById() {
        mCon = PersonalInfomationActivity.this;
        preferences = mCon.getSharedPreferences("Login",MODE_PRIVATE);
        edit = preferences.edit();
        person_titleimage = (ImageView) findViewById(R.id.person_titleimage);
        person_lineartitle = (LinearLayout) findViewById(R.id.person_lineartitle);
        personal_return = (ImageView) findViewById(R.id.personal_return);
        head_portrait = (RelativeLayout) findViewById(R.id.head_portrait);
        mPersonalUserName = (RelativeLayout) findViewById(R.id.mPersonalUserName);
        mPersonalSex = (RelativeLayout) findViewById(R.id.mPersonalSex);
        mDataOfBirth = (RelativeLayout) findViewById(R.id.mDataOfBirth);
        mPersonalPhone = (RelativeLayout) findViewById(R.id.mPersonalPhone);
        mPersonalWx = (RelativeLayout) findViewById(R.id.mPersonalWx);
        mPersonalQq = (RelativeLayout) findViewById(R.id.mPersonalQq);
        mContractAddress = (RelativeLayout) findViewById(R.id.mContractAddress);
        View titleview = LayoutInflater.from(mCon).inflate(R.layout.person_titleimage_popuwindow, null);
        photograph = titleview.findViewById(R.id.Photograph);

        album = titleview.findViewById(R.id.Album);

        cancel = titleview.findViewById(R.id.cancel);

        titlepopuwin = new PopupWindow(titleview, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        titlepopuwin.setOutsideTouchable(true);
        titlepopuwin.setBackgroundDrawable(new ColorDrawable(0x00000000));
        titlepopuwin.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                endbackground();
            }
        });

        View sexView = LayoutInflater.from(mCon).inflate(R.layout.person_sex_popuwin, null);
        man = sexView.findViewById(R.id.man);
        women = sexView.findViewById(R.id.women);
        sexPopuwin = new PopupWindow(sexView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        sexPopuwin.setOutsideTouchable(true);
        sexPopuwin.setBackgroundDrawable(new ColorDrawable(0x00000000));
        sexPopuwin.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                endbackground();
            }
        });
        View timeview = LayoutInflater.from(mCon).inflate(R.layout.person_time_windown, null);
        determine = timeview.findViewById(R.id.time_Determine);
        cancel1 = timeview.findViewById(R.id.time_cancel);
        datePicker = timeview.findViewById(R.id.datePicker);
        timewindow = new PopupWindow(timeview, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        timewindow.setOutsideTouchable(true);
        timewindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        timewindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                endbackground();
            }
        });
        Calendar c = Calendar.getInstance();
        final int[] year1 = {c.get(Calendar.YEAR)};
        c.add(Calendar.MONTH, 1);
        final int[] month1 = {c.get(Calendar.MONTH)};
        final int[] day1 = {c.get(Calendar.DAY_OF_MONTH)};
//        tv1.setText(year1+"-"+month1+"-"+day1);
        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                year1[0] = year;
                month1[0] = monthOfYear + 1;
                day1[0] = dayOfMonth;

                lend_time = new StringBuffer();
                lend_time.append(year1[0]);
                lend_time.append("-");
                lend_time.append(month1[0]);
                lend_time.append("-");
                lend_time.append(day1[0]);
            }
        });

    }

    @Override
    protected void init() {
        determine.setOnClickListener(this);
        cancel1.setOnClickListener(this);
        women.setOnClickListener(this);
        man.setOnClickListener(this);
        cancel.setOnClickListener(this);
        album.setOnClickListener(this);
        photograph.setOnClickListener(this);
        personal_return.setOnClickListener(this);
        head_portrait.setOnClickListener(this);
        mPersonalUserName.setOnClickListener(this);
        mPersonalSex.setOnClickListener(this);
        mDataOfBirth.setOnClickListener(this);
        mPersonalPhone.setOnClickListener(this);
        mPersonalWx.setOnClickListener(this);
        mPersonalQq.setOnClickListener(this);
        mContractAddress.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void openProgress() {

    }

    @Override
    public void closeProgress() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.time_Determine:
                timewindow.dismiss();
                edit.putString("birth",lend_time.toString());
                edit.commit();
                Toast.makeText(mCon, lend_time.toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.time_cancel:
                timewindow.dismiss();
                break;
            case R.id.man:
                sexPopuwin.dismiss();
                String sexMan = man.getText().toString();
                edit.putString("userSex",sexMan);
                edit.commit();
                Toast.makeText(mCon, sexMan, Toast.LENGTH_SHORT).show();
                break;

            case R.id.women:
                sexPopuwin.dismiss();
                String sexWoment = women.getText().toString();
                edit.putString("userSex",sexWoment);
                edit.commit();
                Toast.makeText(mCon, sexWoment, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Photograph:
                chooseFromCamera();
                break;
            case R.id.Album:
                chooseFromGallery();
                break;

            case R.id.cancel:
                titlepopuwin.dismiss();
                break;
            case R.id.personal_return:
                finish();
                break;
            case R.id.head_portrait:
                backgroundAlpha();
                titlepopuwin.showAtLocation(person_lineartitle, Gravity.BOTTOM, 0, 0);
                break;
            case R.id.mPersonalUserName:
                startActivityForResult(new Intent(this, UpdateUserNameActivity.class), REQUESTCODE);
                break;
            case R.id.mPersonalSex:
                backgroundAlpha();
                sexPopuwin.showAtLocation(person_lineartitle, Gravity.BOTTOM, 0, 0);
                break;
            case R.id.mDataOfBirth:
                backgroundAlpha();
                timewindow.showAtLocation(person_lineartitle, Gravity.BOTTOM, 0, 0);
                break;
            case R.id.mPersonalPhone:
                Toast.makeText(mCon, "目前无法修改手机", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mPersonalWx:
                startActivity(new Intent(mCon,UpdateWeiXinActivity.class));
                break;
            case R.id.mPersonalQq:
                startActivity(new Intent(mCon,UpdateQQActivity.class));
                break;
            case R.id.mContractAddress:
                startActivity(new Intent(this, UpdateAddressActivity.class));
                break;
        }
    }

    /**
     * 拍照选择图片
     */
    private void chooseFromCamera() {
        titlepopuwin.dismiss();
        //构建隐式Intent
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //调用系统相机
        startActivityForResult(intent, CAMERA_CODE);
    }

    /**
     * 从相册选择图片
     */
    private void chooseFromGallery() {
        titlepopuwin.dismiss();
        //构建一个内容选择的Intent
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        //设置选择类型为图片类型
        intent.setType("image/*");
        //打开图片选择
        startActivityForResult(intent, GALLERY_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case CAMERA_CODE:
                if (resultCode == RESULT_CANCELED) {
//                    Toast.makeText(this, "取消了拍照", Toast.LENGTH_LONG).show();
                    return;
                }
                if (data != null) {
                    Bitmap photo = data.getParcelableExtra("data");
                    //将Bitmap转化为uri
                    Uri uri = saveBitmap(photo, "temp");
                    //启动图像裁剪
                    startImageZoom(uri);
                }
                break;
            case GALLERY_CODE:
                if (data == null) {
                    return;
                } else {
                    //用户从图库选择图片后会返回所选图片的Uri
                    Uri uri;
                    //获取到用户所选图片的Uri
                    uri = data.getData();
                    //返回的Uri为content类型的Uri,不能进行复制等操作,需要转换为文件Uri
                    try {
                        uri = convertUri(uri);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    startImageZoom(uri);
                }
                break;
            case CROP_CODE:
                if (data == null) {
                    return;
                } else {
                    Bundle extras = data.getExtras();
                    if (extras != null) {
                        //获取到裁剪后的图像
                        Bitmap bm = extras.getParcelable("data");
                        person_titleimage.setImageBitmap(bm);
                    }
                }
                break;
            default:
                break;
        }
    }

    /**
     * 将content类型的Uri转化为文件类型的Uri
     *
     * @param uri
     * @return
     */
    private Uri convertUri(Uri uri) throws IOException {
        InputStream is;
        try {
            //Uri ----> InputStream
            is = getContentResolver().openInputStream(uri);
            //InputStream ----> Bitmap
            Bitmap bm = BitmapFactory.decodeStream(is);
            //关闭流
            is.close();
            return saveBitmap(bm, "temp");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将Bitmap写入SD卡中的一个文件中,并返回写入文件的Uri
     *
     * @param bm
     * @param dirPath
     * @return
     */
    private Uri saveBitmap(Bitmap bm, String dirPath) {
        //新建文件夹用于存放裁剪后的图片
        File tmpDir = new File(Environment.getExternalStorageDirectory() + "/" + dirPath);
        if (!tmpDir.exists()) {
            tmpDir.mkdir();
        }

        //新建文件存储裁剪后的图片
        File img = new File(tmpDir.getAbsolutePath() + "/avator.png");
        try {
            //打开文件输出流
            FileOutputStream fos = new FileOutputStream(img);
            //将bitmap压缩后写入输出流(参数依次为图片格式、图片质量和输出流)
            bm.compress(Bitmap.CompressFormat.PNG, 85, fos);
            //刷新输出流
            fos.flush();
            //关闭输出流
            fos.close();
            //返回File类型的Uri
            return Uri.fromFile(img);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 通过Uri传递图像信息以供裁剪
     *
     * @param uri
     */
    private void startImageZoom(Uri uri) {
        //构建隐式Intent来启动裁剪程序
        Intent intent = new Intent("com.android.camera.action.CROP");
        //设置数据uri和类型为图片类型
        intent.setDataAndType(uri, "image/*");
        //显示View为可裁剪的
        intent.putExtra("crop", true);
        //裁剪的宽高的比例为1:1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        //输出图片的宽高均为150
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        //裁剪之后的数据是通过Intent返回
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_CODE);
    }

    /**
     * 设置添加屏幕的背景透明度
     */
    public void backgroundAlpha() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.7f; //0.0-1.0
        getWindow().setAttributes(lp);
    }

    /**
     * 设置添加屏幕的背景透明度
     */
    public void endbackground() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 1.0f; //0.0-1.0
        getWindow().setAttributes(lp);
    }
}
