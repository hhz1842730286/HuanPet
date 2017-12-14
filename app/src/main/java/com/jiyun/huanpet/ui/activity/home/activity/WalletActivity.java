package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jiyun.huanpet.R;

import static android.R.attr.id;

public class WalletActivity extends AppCompatActivity implements View.OnClickListener {

    private Button proposal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        proposal = (Button) findViewById(R.id.proposal);
        proposal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.proposal:
                 startActivity(new Intent(this,ProposalActivity.class));
                break;
        }
    }
}
