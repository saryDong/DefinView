package com.example.abu.defineview;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.abu.defineview.demodrag.DragActivity;
import com.example.abu.defineview.fragment.NewsItemFragment;
import com.example.abu.defineview.adapter.NewsViewpaerAdappter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private Button titleBtn;
    private List<String> mTabNameList = new ArrayList<>();
    private NewsViewpaerAdappter viewpaerAdappter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleBtn = (Button) findViewById(R.id.titleManager);

        mViewPager = (ViewPager) findViewById(R.id.news_view_paper);
        mTabLayout = (TabLayout) findViewById(R.id.news_tab_layout);
        mTabNameList = (new DragActivity()).getTitleList();
        starttitleLayout();
    }

    private void starttitleLayout() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewpaerAdappter= new NewsViewpaerAdappter(fragmentManager, mTabNameList);
        for (int i = 0; i < mTabNameList.size(); i++){
            viewpaerAdappter.addFragment(new NewsItemFragment(i));
        }
        mViewPager.setAdapter(viewpaerAdappter);

        for (int i = 0; i < mTabNameList.size(); i++){
            mTabLayout.addTab(mTabLayout.newTab().setText(mTabNameList.get(i)));
        }

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        titleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, DragActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       // super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK){
                    List<String> titleList=data.getStringArrayListExtra("TitleList");
                    mTabNameList=titleList;
                    starttitleLayout();
                }
                break;
            default:
        }
    }
}
