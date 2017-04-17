package com.ma.androidtools.ui.pull.adapter;

import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * Created by binbin.ma on 2017/4/13.
 */

public class DiffCallBack extends DiffUtil.Callback {

    private List<Object> olddatas;
    private List<Object> newDatas;

    public DiffCallBack(List<Object> olddatas, List<Object> newDatas) {
        this.olddatas = olddatas;
        this.newDatas = newDatas;
    }

    @Override
    public int getOldListSize() {
        return olddatas.size();
    }

    @Override
    public int getNewListSize() {
        return newDatas.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return olddatas.get(oldItemPosition).equals(newDatas.get(newItemPosition));
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return olddatas.get(oldItemPosition).equals(newDatas.get(newItemPosition));
    }
}
