package com.app.summer.testdemo.recycleView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * @author jingwei
 * date: 2019/8/7
 * desc: ViewHolder 基类
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    private View itemView;
    private SparseArray<View> viewSparseArray;

    public BaseViewHolder(View itemView) {
        super(itemView);

        this.itemView = itemView;
        this.viewSparseArray = new SparseArray<>();
    }

    public <T extends View> T findViewById(int viewId) {
        View view = viewSparseArray.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            viewSparseArray.put(viewId, view);
        }
        return (T) view;
    }

    public View getItemView() {
        return itemView;
    }
}
