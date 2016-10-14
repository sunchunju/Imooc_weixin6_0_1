package com.imooc.imooc_weixin6_0_1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private LinearLayout weixinLl;
    private LinearLayout friendLl;
    private LinearLayout findLl;
    private LinearLayout settingsLl;

    private ArrayList<Fragment> frgList;

    public static final int WEIXIN_PAGE = 0;
    public static final int FRIEND_PAGE = 1;
    public static final int FIND_PAGE = 2;
    public static final int SETTING_PAGE = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();

    }

    private void initEvent() {
        weixinLl.setOnClickListener(this);
        friendLl.setOnClickListener(this);
        findLl.setOnClickListener(this);
        settingsLl.setOnClickListener(this);

        viewPager.setOnPageChangeListener(this);
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.vp_list);
        weixinLl = (LinearLayout) findViewById(R.id.ll_weixin);
        friendLl = (LinearLayout) findViewById(R.id.ll_friend);
        findLl = (LinearLayout) findViewById(R.id.ll_find);
        settingsLl = (LinearLayout) findViewById(R.id.ll_setting);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        frgList = new ArrayList<>();
        frgList.add(new weixinFragment());
        frgList.add(new friendFragment());
        frgList.add(new findFragment());
        frgList.add(new settingFragment());

        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), frgList));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.ll_weixin:
                viewPager.setCurrentItem(WEIXIN_PAGE);
                break;
            case R.id.ll_friend:
                viewPager.setCurrentItem(FRIEND_PAGE);
                break;
            case R.id.ll_find:
                viewPager.setCurrentItem(FIND_PAGE);
                break;
            case R.id.ll_setting:
                viewPager.setCurrentItem(SETTING_PAGE);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> list;
        public MyFragmentPagerAdapter(FragmentManager supportFragmentManager, ArrayList<Fragment> frgList) {
            super(supportFragmentManager);
            this.list = frgList;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
