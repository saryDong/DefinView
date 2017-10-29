package com.example.abu.defineview.demodrag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.abu.defineview.R;
import com.example.abu.defineview.Utils.MydecorationPading;
import com.example.abu.defineview.Utils.TitleItemDecoration;
import com.example.abu.defineview.beans.FocusTitle;
import com.example.abu.defineview.adapter.SpecialRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TitleStateActivity extends AppCompatActivity {
    private static final int TITLE_SELECTED=1;
    private static final int TITLE_DISSELECT=0;
    private List<FocusTitle> seansonlist;
    String[] arrayTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_state);

        seansonlist=new ArrayList<>();


        arrayTitle=getResources().getStringArray(R.array.focusTitle);

        init();

        RecyclerView recycler= (RecyclerView) findViewById(R.id.seasion_recycler_recycler);

        GridLayoutManager manager=new GridLayoutManager(this,2);

        recycler.setLayoutManager(manager);

        SpecialRecyclerAdapter adapter=new SpecialRecyclerAdapter(seansonlist);

        recycler.setAdapter(adapter);
       // recycler.addItemDecoration(new TitleItemDecoration(this,seansonlist));
        //recycler.addItemDecoration(new MydecorationPading(this));
    }
    public void init(){
        for (int i=0;i<20;i++){
            FocusTitle focusTitle=new FocusTitle();
            if (i==0){
                focusTitle.setTitleName(arrayTitle[i]);
                focusTitle.setTitleState("GROUP_NAME");
            }else if (i>=1&&i<=4){
                focusTitle.setTitleName(arrayTitle[i]);
                focusTitle.setTitleState("DATA");
            }else if (i==5){
                focusTitle.setTitleName(arrayTitle[i]);
                focusTitle.setTitleState("GROUP_NAME");
            }else {
                focusTitle.setTitleName(arrayTitle[i]);
                focusTitle.setTitleState("DATA");
            }
            seansonlist.add(focusTitle);
        }

    }
}
