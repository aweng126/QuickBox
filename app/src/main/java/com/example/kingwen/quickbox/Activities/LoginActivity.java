package com.example.kingwen.quickbox.Activities;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.kingwen.quickbox.R;

/**
 * Created by kingwen on 2016/12/11.
 */
public class LoginActivity extends BaseActivity {

    /**
     * 输入用户名的edittext控件
     */
    private EditText et_name;

    /**
     * 输入用户密码的edittext控件
     */
    private EditText et_pass;

    /**
     * 确认登录的button控件
     */
    private Button btn_login;

    /**
     * 用于保存用户名控件内容的变量
     */
    private String name;

    /**
     * 用于保存密码控件内容的变量
     */
    private  String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        initListener();

    }

    /**
     * 初始化view
     */
    private void initViews() {
        et_name= (EditText) findViewById(R.id.et_inputName_login);
        et_pass= (EditText) findViewById(R.id.et_inputPassword_login);
        btn_login= (Button) findViewById(R.id.btn_login);

    }

    /**
     * 设置button的监听事件
     */
    private void initListener() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=et_name.getText().toString();
                pass=et_pass.getText().toString();
                if(judgeLegal(name,pass)){

                    startMyActivity(LoginActivity.this,MainActivity.class);

                }else {
                    Toast.makeText(LoginActivity.this,"用户名或密码不合法,请重新输入",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * 判断用户名和密码是否符合合法
     * @param name  需要判断的用户名
     * @param pass  需要判断的用户名对应的密码
     * @return true  合法 ； false 不合法
     */
    private boolean judgeLegal(String name, String pass) {

        if("".equals(name)||"".equals(pass)){
            return false;
        }

        return true;
    }
}
