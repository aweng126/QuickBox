package com.example.kingwen.quickbox.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kingwen.quickbox.R;

/**
 * Created by kingwen on 2016/12/12.
 */
public class WelcomeActivity extends BaseActivity {

    /**
     * Tag
     */
    private static final String TAG="WelcomeActivity";

    /**
     * 进入登录界面
     */
    private Button btn_login;

    /**
     * 进入注册界面的button
     */
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initViews();

        initListeners();
    }

    /**
     * 设置监听事件
     */
    private void initListeners() {

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMyActivity(WelcomeActivity.this,LoginActivity.class);
            }
        });



        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMyActivity(WelcomeActivity.this,RegisterActivity.class);
            }
        });


    }

    /**
     * 初始化view
     */
    private void initViews() {
        btn_login= (Button) findViewById(R.id.btn_login_welcome);
        btn_register= (Button) findViewById(R.id.btn_register_welcome);
    }
}
