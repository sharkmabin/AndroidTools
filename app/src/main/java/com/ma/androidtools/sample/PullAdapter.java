package com.ma.androidtools.sample;

import android.content.Context;

import com.ma.androidtools.R;
import com.ma.androidtools.ui.pull.adapter.RecyclerAdapter;
import com.ma.androidtools.ui.pull.adapter.ViewHolder;

import java.util.List;

/**
 * Created by binbin.ma on 2017/4/17.
 */

public class PullAdapter extends RecyclerAdapter {


    private List<Object> list;
    private Context context;

    public PullAdapter(Context context, List<Object> list) {
        super(context, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemLayoutId(int viewId) {
        return R.layout.item;
    }

    @Override
    public void bindData(ViewHolder holder, int position, Object item) {
        holder.getTextView(R.id.text).setText(list.get(position)+"");
    }
}
