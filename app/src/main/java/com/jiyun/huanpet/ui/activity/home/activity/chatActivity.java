package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.ui.EaseChatFragment;
import com.jiyun.huanpet.R;
import com.jiyun.huanpet.ui.base.BaseActivity;

/**
 * Created by lh on 2017/12/21.
 */

public class chatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char);
        EaseChatFragment chatFragment = new EaseChatFragment();
        Bundle extras = getIntent().getExtras();
        chatFragment.setArguments(extras);
        getSupportFragmentManager().beginTransaction().add(R.id.chat_fragment, chatFragment).commit();
    }

}
