package com.example.kingwen.quickbox.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kingwen.quickbox.Fragments.EntertainmentFragment;
import com.example.kingwen.quickbox.Fragments.GameFragment;
import com.example.kingwen.quickbox.Fragments.NewsFragment;
import com.example.kingwen.quickbox.Fragments.SchoolFragment;
import com.example.kingwen.quickbox.Fragments.ShoppingFragment;
import com.example.kingwen.quickbox.Fragments.SocietyFragment;
import com.example.kingwen.quickbox.R;

public class MainActivity extends  BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG="MainActivity";

    /**
     * 保存当前fragment
     */
    private Fragment currentFragment=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolBar();

       // setFloatingButton();

        setNavigationView();

        initViews();

        initListeners();

        setDefaultFragment();

    }

    /**
     * 设置默认的fragment
     */
    private void setDefaultFragment() {

        currentFragment=new ShoppingFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.main_contain,currentFragment,"ONE").commit();

    }

    private void initListeners() {


    }

    private void initViews() {
    }

    /**
     * 侧滑栏
     */
    private void setNavigationView() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    /**
     * 标题栏
     */
    private void setToolBar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_shopping) {

            currentFragment=new ShoppingFragment();

        } else if (id == R.id.nav_game) {

            currentFragment=new GameFragment();

        } else if (id == R.id.nav_entertainment) {

            currentFragment=new EntertainmentFragment();

        } else if (id == R.id.nav_society) {

            currentFragment=new SocietyFragment();

        } else if (id == R.id.nav_school) {

            currentFragment=new SchoolFragment();

        } else if (id == R.id.nav_news) {

            currentFragment=new NewsFragment();

        }else if (id == R.id.nav_exit) {
          //退出所有活动，返回到登录界面


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);


        getSupportFragmentManager().beginTransaction().replace(R.id.main_contain,currentFragment).commit();
        Log.e(TAG, "onNavigationItemSelected: currentFragment"+currentFragment.getClass().getName()+"" );

        return true;
    }


  /*  *//**
     * 悬浮按钮
     *//*
    private void setFloatingButton() {

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    */



    /*
    * 菜单
    * */

      /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
}
