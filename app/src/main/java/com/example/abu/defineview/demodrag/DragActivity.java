package com.example.abu.defineview.demodrag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.abu.defineview.R;
import com.example.abu.defineview.helper.ItemDragHelperCallback;

import java.util.ArrayList;
import java.util.List;


/**
 * 拖拽
 * Created by YoKeyword on 16/1/4.
 */
public class DragActivity extends AppCompatActivity{
    private RecyclerView mRecy;
    List<String> titlelist;
    List<String> items;
    private Button addmore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        addmore= (Button) findViewById(R.id.add_more);
        mRecy = (RecyclerView) findViewById(R.id.recy);
        titlelist=new ArrayList<>();
        init();
        addmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DragActivity.this,TitleStateActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        initTitle();
        GridLayoutManager manager = new GridLayoutManager(this, 5);
        mRecy.setLayoutManager(manager);

        ItemDragHelperCallback callback = new ItemDragHelperCallback(){
            @Override
            public boolean isLongPressDragEnabled() {
                // 长按拖拽打开
                return true;
            }
        };
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(mRecy);

        DragAdapter adapter = new DragAdapter(this, items);
        adapter.setGiveback(giveback);

        mRecy.setAdapter(adapter);
        mRecy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    DragAdapter.Giveback giveback=new DragAdapter.Giveback() {
        @Override
        public void ListTile(List<String> mlist) {
               titlelist=mlist;
        }
    };

    @Override
    public void onBackPressed() {
        Intent intent=new Intent();
        intent.putStringArrayListExtra("TitleList",(ArrayList<String>) titlelist);
        setResult(RESULT_OK,intent);
        finish();
    }
    public List<String> getTitleList(){
        initTitle();
        return items;
    }

    private void initTitle() {
        items = new ArrayList<>();
        for (int i = 0; i <10; i++) {
            items.add("Index " + i);
        }
    }

}