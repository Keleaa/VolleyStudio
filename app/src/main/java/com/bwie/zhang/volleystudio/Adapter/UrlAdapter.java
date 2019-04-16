package com.bwie.zhang.volleystudio.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.zhang.volleystudio.Bean.UrlBean;
import com.bwie.zhang.volleystudio.R;

import java.util.List;

/**
 * Created by 可乐 on 2019/4/16.
 */

public class UrlAdapter extends RecyclerView.Adapter<UrlAdapter.ViewHolder> {
    Context context;
    List<UrlBean.ResultsBean> list;

    public UrlAdapter(Context context, List<UrlBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(list.get(i).getUrl()).apply(RequestOptions.centerCropTransform()).into(viewHolder.imageView);
        Log.i("ddd", "onBindViewHolder: " + "+" + list.get(i).getUrl());
        viewHolder.textViewView.setText(list.get(i).get_id());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textViewView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_item);
            textViewView = itemView.findViewById(R.id.textView_item);
        }
    }
}
