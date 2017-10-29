package com.example.abu.defineview.demodrag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.abu.defineview.R;
import com.example.abu.defineview.beans.NewsTitleBean;

public class DetailActivity extends AppCompatActivity {
    TextView title;
    TextView content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        title= (TextView) findViewById(R.id.content_title);
        content= (TextView) findViewById(R.id.content);
        NewsTitleBean  titleBeann= (NewsTitleBean) getIntent().getSerializableExtra("content");
        title.setText(titleBeann.getTitleName());
        content.setText(titleBeann.getTitleName());
    }
}
