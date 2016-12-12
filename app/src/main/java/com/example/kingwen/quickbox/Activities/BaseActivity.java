package com.example.kingwen.quickbox.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.security.Key;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by kingwen on 2016/12/12.
 */
public class BaseActivity extends AppCompatActivity {

    /**
     * TAG
     */
    private static  final  String TAG="BaseActivity";

    /**
     * 用于保存全局上下文对象的context
     */
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext=getApplicationContext();

    }

    /**
     * 弹出框
     * @param content
     */
    public void showToast(String content){
        Toast.makeText(mContext,content,Toast.LENGTH_SHORT).show();
    }


    /**
     * 活动启动
     * @param context 上下文对象
     * @param cls     要打开的活动类
     */
    public void startMyActivity(Context context, Class<?> cls){
        Intent intent=new Intent(context,cls);
        startActivity(intent);
    }


    /**
     * 当前活动开启另一个活动，同时传递数据，无返回值
     * @param context  上下文对象
     * @param cls      要打开的活动类
     * @param dataMap  要进行传递的数据Map
     */
    public void startMyActivityWithData(Context context,Class<?> cls,Map dataMap){
       Intent intent=new Intent(context,cls);
        Iterator iterator=dataMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,String> entry= (Map.Entry) iterator.next();
            intent.putExtra(entry.getKey(),entry.getValue());
        }
        context.startActivity(intent);
    }

}
