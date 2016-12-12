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
public class RegisterActivity extends  BaseActivity {

    /**
     * 输入用户名的edittext控件
     */
    private EditText et_name;

    /**
     * 输入用户密码的edittext控件
     */
    private EditText et_pass;

    /**
     * 输入用户密码的edittext控件
     */
    private EditText et_confirmpass;

    /**
     * 确认登录的button控件
     */
    private Button btn_register;

    /**
     * 用于保存用户名控件内容的变量
     */
    private String name;

    /**
     * 用于保存密码控件内容的变量
     */
    private  String pass;


    /**
     * 用于保存确认密码控件内容的变量
     */
    private  String confirmpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();

        initListeners();


    }

    /**
     * 初始化view
     */
    private void initViews() {
        et_name= (EditText) findViewById(R.id.et_inputName_register);
        et_pass= (EditText) findViewById(R.id.et_inputPassword_register);
        et_confirmpass= (EditText) findViewById(R.id.et_inputPassword_confirm);
        btn_register= (Button) findViewById(R.id.btn_register);


    }

    /**
     * 添加监听事件
     */
    private void initListeners() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=et_name.getText().toString();
                pass=et_pass.getText().toString();
                confirmpass=et_confirmpass.getText().toString();

                if(judgeLegal(name,pass,confirmpass)){

                    startMyActivity(RegisterActivity.this,LoginActivity.class);

                }else {
                    Toast.makeText(RegisterActivity.this, "用户名或密码不合法,请重新输入", Toast.LENGTH_SHORT).show();
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
    private boolean judgeLegal(String name, String pass,String confirmpass) {

        if("".equals(name)||"".equals(pass)||!pass.equals(confirmpass)){
            return false;
        }

        return true;
    }
}
