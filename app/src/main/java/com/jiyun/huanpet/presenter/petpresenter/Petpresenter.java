package com.jiyun.huanpet.presenter.petpresenter;

import android.util.Log;

import com.jiyun.huanpet.model.api.HttpCallback;
import com.jiyun.huanpet.model.biz.pet.IPetModle;
import com.jiyun.huanpet.model.biz.pet.PetModle;

/**
 * Created by Lenovo on 2017/12/18.
 */

public class Petpresenter implements IPetContract.Presenter {
private IPetModle iPetModle;
private IPetContract.View petview;

    public Petpresenter() {
        this.iPetModle =new PetModle();
    }

    @Override
    public void attchTo(IPetContract.View view) {
        petview=view;
    }

    @Override
    public void detach() {

    }

    @Override
    public void pet(String userId) {
     iPetModle.petlist(userId, new HttpCallback() {
         @Override
         public void success(Object o) {
//             Gson gson=new Gson();
//             String string = o.toString();
//             Log.e( "==== ",string );
//             Petadd petadd = gson.fromJson(string, Petadd.class);
//             petview.pet(petadd);
         }
         @Override
         public void error(String error) {

         }
     });
    }

    @Override
    public void petadd(String petName, int PetType, String userName, String CreateTime, String petBirthTime, String petInfo, String petTypeName, String isSterilization, String petWeight, String isimmune, String userId) {
        iPetModle.petadd(petName, PetType, userName, CreateTime, petBirthTime, petInfo, petTypeName, isSterilization, petWeight, isimmune, userId, new HttpCallback() {
            @Override
            public void success(Object o) {
                String string = o.toString();
                Log.e("8888888",string);

            }

            @Override
            public void error(String error) {

            }
        });
    }


}
