package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.codbking.widget.DatePickDialog;
import com.codbking.widget.OnSureLisener;
import com.codbking.widget.bean.DateType;
import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.petpresenter.Petpresenter;
import com.jiyun.huanpet.ui.activity.home.bean.Petadd;
import com.jiyun.huanpet.ui.base.BaseActivity;
import com.jiyun.huanpet.utils.utilspet.Formation;
import com.jiyun.huanpet.utils.utilspet.UploadUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.jiyun.huanpet.constants.Constants.REQUESTCODE;

//添加宠物
public class AddPetActivity extends BaseActivity<Petpresenter> implements View.OnClickListener {
    private ImageView Back_gray;
    private RelativeLayout Pet_Type;
    private RelativeLayout immune_state;
    private PopupWindow popupWindow;
    private TextView photograph;
    private TextView photo_album;
    private TextView cancel;
    private ImageView Head_portrait_imager;
    private TextView Save;
    private RelativeLayout Head_portrait, Nickname, Of_birth, Weight, Whether;
    private static final int CAMERA_CODE = 1;
    private static final int GALLERY_CODE = 2;
    private static final int CROP_CODE = 3;
    private TextView Nick_Name, Date_of_birth, Weight_figure, Sterilization;
    private TextView yes;
    private TextView no;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private EditText Information,Edit_text;
    // 得到昵称的返回值
    private String resultNick;
    // 得到体重的返回值
    private String resultWeight;
    // 宠物类型
    private String petType;
    // 出生日期
    private String petDate;
    // 是否绝育
    private String yesOrNo;
    // 宠物简介
    private String petInfo;
    // 免疫信息
    private boolean isImmune = false;
    // 是否绝育
    private boolean isSterilization = false;
    // 病毒类型
    private String str = "已免疫";
    // 图片路径
    private String imgPath;

    private Map<String, File> iconMap=new HashMap<>();

    private int isSex = 2;

    private String typeCode;
    private Map<String, Object> map = new HashMap<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_pet;
    }

    @Override
    protected void findViewById() {
        Back_gray = (ImageView) findViewById(R.id.Back_gray);
        Back_gray.setOnClickListener(this);
        Save = (TextView) findViewById(R.id.Save);
        Save.setOnClickListener(this);
        Head_portrait = (RelativeLayout) findViewById(R.id.Head_portrait);
        Head_portrait.setOnClickListener(this);
        Pet_Type = (RelativeLayout) findViewById(R.id.Pet_Type);
        Pet_Type.setOnClickListener(this);
        immune_state = (RelativeLayout) findViewById(R.id.immune_state);
        immune_state.setOnClickListener(this);
        Head_portrait_imager = (ImageView) findViewById(R.id.Head_portrait_imager);

        Nickname = (RelativeLayout) findViewById(R.id.Nickname);
        Nickname.setOnClickListener(this);
        Nick_Name = (TextView) findViewById(R.id.Nick_Name);
        Of_birth = (RelativeLayout) findViewById(R.id.Of_birth);
        Of_birth.setOnClickListener(this);
        Date_of_birth = (TextView) findViewById(R.id.Date_of_birth);
        Weight = (RelativeLayout) findViewById(R.id.Weight);
        Weight.setOnClickListener(this);
        Weight_figure = (TextView) findViewById(R.id.Weight_figure);
        Whether = (RelativeLayout) findViewById(R.id.Whether);
        Whether.setOnClickListener(this);
        Sterilization = (TextView) findViewById(R.id.Sterilization);
        Information= (EditText) findViewById(R.id.Information);
        Edit_text= (EditText) findViewById(R.id.Edit_text);
    }

    @Override
    protected void init() {
//        preferences =AddPetActivity.this.getSharedPreferences("Login", MODE_PRIVATE);
//        String userId = preferences.getString("userId", null);
//        Request.Builder builder = new Request.Builder();
//        OkHttpClient build = new OkHttpClient.Builder().build();
//        Petadd pet = new Petadd();
//        pet.setPetName(Nick_Name.toString());
//        pet.setPetType("Int(否)");
//        pet.setIsSterilization(1);
//        pet.setPetSex(1);
//        pet.setPetBirthTime(Date_of_birth.toString());
//        pet.setCreateTime((new SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
//        pet.setPetWeight(Double.parseDouble("2.5"));
//        pet.setPetInfo("西伯利亚雪橇犬");
//        pet.setPetTypeName("哈士奇");
//        pet.setIsimmune(0);
//        pet.setUserId(userId);
//        pet.setUserName("xxxx");
//        AddPetActivity.this.map.put("petInfo-"+userId,pet);
//        FormBody.Builder bodyBuilder = new FormBody.Builder();
//        bodyBuilder.add("data", CJSON.toJSONMap(map));
//        Request request = builder.url(Urls.PETADD).post(bodyBuilder.build()).build();
//        Call call = build.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e("-----------",e.getMessage());
//            }
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String string = response.body().string();
//                Log.e("tttttttttttt",string);
//            }
//        });

//        (new Thread(new Runnable() {
//            public void run() {
//                String string = UploadUtil.uploadFile(AddPetActivity.this.iconMap, Urls.PETADD, AddPetActivity.this.map);
//                Log.i("TAG", string);
//                AddPetActivity.this.runOnUiThread(new Runnable() {
//                    public void run() {
//                        Toast.makeText(AddPetActivity.this, "添加成功",Toast.LENGTH_LONG).show();
//                    }
//                });
//                AddPetActivity.this.finish();
//            }
//        })).start();



    }


    private boolean noNull() {
        petInfo = Edit_text.getText().toString().trim();
        String petImmune = Information.getText().toString().trim();
        if (petImmune.equals("未完善信息")) {
            isImmune = false;
        } else {
            isImmune = true;

        }
        if (resultNick == null || resultNick.isEmpty()) {
            Toast.makeText(this, "请填写宠物昵称", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (resultWeight == null || resultWeight.isEmpty()) {
            Toast.makeText(this, "请填写宠物体重", Toast.LENGTH_SHORT).show();

            return false;
        }
        if (petType == null || petType.isEmpty()) {
            Toast.makeText(this, "请填写宠物类型", Toast.LENGTH_SHORT).show();

            return false;
        }
        if (petDate == null || petDate.isEmpty()) {
            Toast.makeText(this, "请填写宠物生日", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (yesOrNo == null || yesOrNo.isEmpty()) {
            Toast.makeText(this, "请填写宠物是否绝育", Toast.LENGTH_SHORT).show();

            return false;
        }
        if (petInfo == null || petInfo.isEmpty()) {
            Toast.makeText(this, "请填写宠物简介", Toast.LENGTH_SHORT).show();

            return false;
        }
        if (isSex == 2) {
            Toast.makeText(this, "请填写宠物简介", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    protected void loadData() {
        preferences =AddPetActivity.this.getSharedPreferences("Login", MODE_PRIVATE);
        String userId = preferences.getString("userId", null);
        if (noNull()) {
            Petadd pet = new Petadd();
            pet.setPetName(resultNick);
            pet.setPetType(typeCode);
            Log.i("TAG", typeCode + "code3");
            pet.setIsSterilization(isSterilization ? 1 : 2);
            pet.setPetSex(isSex);
            pet.setPetBirthTime(petDate);
            pet.setCreateTime(new SimpleDateFormat("yyyy-MM-dd")
                    .format(new Date()));
            pet.setPetWeight(Double.parseDouble(resultWeight));
            pet.setPetInfo(petInfo);
            pet.setPetTypeName(petType);
            pet.setIsimmune(isImmune ? 1 : 0);
            pet.setUserId(userId);
            pet.setUserName("xxxx");
            map.put("petInfo-" + userId, pet);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String string = UploadUtil.uploadFile(iconMap,
                            "http://123.56.150.230:8885/petInfo/savePetInfo.jhtml", map);
                    Log.i("TAG", string);
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(AddPetActivity.this, "添加成功",
                                    Toast.LENGTH_LONG).show();

                        }
                    });
                    finish();
                }
            }).start();
        }
    }


//        @Override
//        protected void loadData () {
//        preferences =AddPetActivity.this.getSharedPreferences("Login", MODE_PRIVATE);
//        editor = preferences.edit();
//        String userId = preferences.getString("userId", null);
//        editor.commit();
//        Request.Builder builder = new Request.Builder();
//        OkHttpClient build = new OkHttpClient.Builder().build();
//        Map<String,Object> mapq=new HashMap<>();
//        Petadd petadd=new Petadd();
//        petadd.setPetName("多个省份");
//            //类型typecode
//        petadd.setPetType();
//            //是否绝育
//        petadd.setIsSterilization(1);
//        petadd.setPetSex(1);
//        petadd.setPetBirthTime("2017-12-19");
//        petadd.setCreateTime(new SimpleDateFormat("yyyy-MM-dd")
//                .format(new Date()));
//        petadd.setPetWeight(Double.parseDouble());
//        petadd.setPetInfo();
//        petadd.setPetTypeName();
//        petadd.setIsimmune(0);
//        petadd.setUserId();
//        petadd.setUserName();
//        FormBody.Builder bodyBuilder = new FormBody.Builder();
//        bodyBuilder.add("data", CJSON.toJSONMap(mapq));
//        Request request = builder.url(Urls.INDENT).post(bodyBuilder.build()).build();
//        Call call = build.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e("-----------",e.getMessage());
//            }
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String string = response.body().string();
//                Log.e("tttttttttttt",string);
//            }
//        });
//        }




        @Override
        public void onClick (View v){
            switch (v.getId()) {
                case R.id.Save:
                    startActivity(new Intent(AddPetActivity.this, PetActivity.class));
                    break;
                case R.id.Head_portrait:
                    showopenPop();
                    break;
                case R.id.Nickname:
                    Intent intent = new Intent(AddPetActivity.this, UpdateUserNameActivity.class);
                    startActivityForResult(intent, 1000);
                    break;
                case R.id.Pet_Type:
                    startActivityForResult(new Intent(this, PetTypeActivity.class), REQUESTCODE);
                    break;
                case R.id.Of_birth:
                    showbirthPopup();
                    break;
                case R.id.Weight:
                    Intent intent2 = new Intent(AddPetActivity.this, UpdateUserNameActivity.class);
                    startActivityForResult(intent2, 3000);
                    break;
                case R.id.immune_state:
                    startActivity(new Intent(this, PetMianYiActivity.class));
                    break;
                case R.id.Back_gray:
                    finish();
                    break;
                case R.id.Photograph:
                    chooseFromCamera();
                    break;
                case R.id.photo_album:
                    chooseFromGallery();
                    break;
                case R.id.Cancel:
                    popupWindow.dismiss();
                    break;
                case R.id.Whether:
                    showPopWindow();
                    break;
                case R.id.Yes:
                    String trim = yes.getText().toString().trim();
                    Sterilization.setText(trim);
                    popupWindow.dismiss();
                    break;
                case R.id.No:
                    String trim1 = no.getText().toString().trim();
                    Sterilization.setText(trim1);
                    popupWindow.dismiss();
                    break;

            }

        }

    public void showbirthPopup() {
        DatePickDialog dialog = new DatePickDialog(AddPetActivity.this);
        //设置上下年分限制
        dialog.setYearLimt(5);
        //设置标题
        dialog.setTitle("选择时间");
        //设置类型
        dialog.setType(DateType.TYPE_YMD);
        //设置消息体的显示格式，日期格式
        dialog.setMessageFormat("yyyy-MM-dd HH:mm");
        //设置选择回调
        dialog.setOnChangeLisener(null);
        //设置点击确定按钮回调
        dialog.setOnSureLisener(new OnSureLisener() {
            @Override
            public void onSure(Date date) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String str = sdf.format(date);
                Date_of_birth.setText(str);
            }
        });
        dialog.show();
    }

    public void showPopWindow() {
        popupWindow = new PopupWindow(this);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        View inflate = LayoutInflater.from(this).inflate(R.layout.activity_whetherpopupwindow, null);
        yes = inflate.findViewById(R.id.Yes);
        yes.setOnClickListener(this);
        no = inflate.findViewById(R.id.No);
        no.setOnClickListener(this);
        popupWindow.setContentView(inflate);
        popupWindow.setBackgroundDrawable(new ColorDrawable(15189737));
        popupWindow.showAtLocation(findViewById(R.id.Line), Gravity.CENTER, 0, 400);
        WindowManager.LayoutParams lp = AddPetActivity.this.getWindow().getAttributes();
//0到1,调整亮度暗到全亮
        lp.alpha = 0.5f;
        AddPetActivity.this.getWindow().setAttributes(lp);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.alpha = 1f;
                getWindow().setAttributes(attributes);
            }
        });
    }

    public void showopenPop() {
        popupWindow = new PopupWindow(this);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        View inflate = LayoutInflater.from(this).inflate(R.layout.popup_activity, null);
        photograph = inflate.findViewById(R.id.Photograph);
        photograph.setOnClickListener(this);
        photo_album = inflate.findViewById(R.id.photo_album);
        photo_album.setOnClickListener(this);
        cancel = inflate.findViewById(R.id.Cancel);
        cancel.setOnClickListener(this);
        popupWindow.setContentView(inflate);
        popupWindow.setBackgroundDrawable(new ColorDrawable(15189737));
        popupWindow.showAtLocation(findViewById(R.id.Line), Gravity.CENTER, 0, 400);
        WindowManager.LayoutParams lp = AddPetActivity.this.getWindow().getAttributes();
//0到1,调整亮度暗到全亮
        lp.alpha = 0.5f;
        AddPetActivity.this.getWindow().setAttributes(lp);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.alpha = 1f;
                getWindow().setAttributes(attributes);
            }
        });
    }

    private void chooseFromCamera() {
        //构建隐式Intent
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //调用系统相机
        startActivityForResult(intent, CAMERA_CODE);
    }

    /**
     * 从相册选择图片
     */
    private void chooseFromGallery() {
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
            case 1000:
                if (requestCode == 1000 && resultCode == 2000) {
                    String name = data.getStringExtra("name");
                    Nick_Name.setText(name);
                }
                break;
            case 3000:
                if (requestCode == 3000 && resultCode == 2000) {
                    String date = data.getStringExtra("date");
                    Weight_figure.setText(date);
                }
                break;
            case CAMERA_CODE:
                if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(this, "取消了拍照", Toast.LENGTH_LONG).show();
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
                    uri = convertUri(uri);
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
                        Formation formation = new Formation(this);
                        Bitmap bitmap = formation.getBitmap(bm);
                        Head_portrait_imager.setImageBitmap(bitmap);
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
    private Uri convertUri(Uri uri) {
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }
}
