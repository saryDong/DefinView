package com.example.abu.defineview.demodrag;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abu.defineview.R;
import com.example.abu.defineview.helper.OnDragVHListener;
import com.example.abu.defineview.helper.OnItemMoveListener;

import java.util.List;


/**
 * 仅拖拽排序
 * Created by YoKeyword on 16/1/4.
 */
public class DragAdapter extends RecyclerView.Adapter<DragAdapter.DragViewHolder> implements OnItemMoveListener {
    private List<String> mItems;
    private LayoutInflater mInflater;

    public DragAdapter(Context context, List<String> items) {
        mInflater = LayoutInflater.from(context);
        this.mItems = items;
    }

    @Override
    public DragViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final DragViewHolder viewHolder=new DragViewHolder(mInflater.inflate(R.layout.item_drag, parent, false));
        viewHolder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveMyToOther(viewHolder);
            }
        });
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(DragViewHolder holder, int position) {
        holder.tv.setText(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        String item = mItems.get(fromPosition);
        mItems.remove(fromPosition);
        mItems.add(toPosition, item);
        giveback.ListTile(mItems);
        notifyItemMoved(fromPosition, toPosition);
    }


    class DragViewHolder extends RecyclerView.ViewHolder implements OnDragVHListener {
        TextView tv;

        public DragViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemFinish() {
            itemView.setBackgroundColor(0);
        }

    }
    private void moveMyToOther(DragViewHolder myHolder) {
        int position = myHolder.getAdapterPosition();
        mItems.remove(position);
        notifyDataSetChanged();
    }
    public  interface Giveback{
        void ListTile(List<String> mlist);
    }
    Giveback giveback;
    public  void setGiveback(Giveback giveback){
        this.giveback=giveback;
    }
}
