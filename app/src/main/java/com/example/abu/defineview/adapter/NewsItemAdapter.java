package com.example.abu.defineview.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abu.defineview.R;
import com.example.abu.defineview.beans.NewsTitleBean;
import com.example.abu.defineview.demodrag.DetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abu on 2017/10/17.
 */

public class NewsItemAdapter extends RecyclerView.Adapter<NewsItemAdapter.ViewHolder> {
    private List<NewsTitleBean> titleBeanList;
    private int position;
    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView newsTitle;
        private TextView newsDatefrom;
        private TextView newstouchTime;
        private int position;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.news_img);
            newsTitle= (TextView) itemView.findViewById(R.id.news_title);
            newsDatefrom= (TextView) itemView.findViewById(R.id.news_datefrom);
            newstouchTime= (TextView) itemView.findViewById(R.id.news_datetime);

        }
    }

    public NewsItemAdapter(List<NewsTitleBean> titleBeanList) {
        this.titleBeanList = titleBeanList;
    }

    @Override
    public NewsItemAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_newsitem,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(parent.getContext(), DetailActivity.class);
                intent.putExtra("content",titleBeanList.get(position));
                parent.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(NewsItemAdapter.ViewHolder holder, int position) {
           NewsTitleBean titleBean=titleBeanList.get(position);
           holder.imageView.setImageResource(titleBean.getImageId());
           holder.newsTitle.setText(titleBean.getTitleName());
           holder.newstouchTime.setText(titleBean.getTouchtime());
           holder.newsDatefrom.setText(titleBean.getDatefrom());
           this.position=position;
    }

    @Override
    public int getItemCount() {
        return titleBeanList.size();
    }
}
