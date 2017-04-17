package com.ma.androidtools.ui.pull.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Date;
import java.util.List;

/**
 * Created by binbin.ma on 2017/4/13.
 */

public abstract class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    abstract public int getItemLayoutId(int viewId);
    abstract public void bindData(ViewHolder holder, int position, Object item);

    private Context context;
    private List<Object> list;
    private LayoutInflater inflater;

    public RecyclerAdapter(Context context, List<Object> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final ViewHolder holder = new ViewHolder(
                inflater.inflate(getItemLayoutId(viewType), parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        bindData(holder, position, list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void add(int positon, Object item) {
        list.add(positon, item);
        notifyItemInserted(positon);
    }

    public void delete(int positon) {
        list.remove(positon);
        notifyItemRemoved(positon);
    }

}
