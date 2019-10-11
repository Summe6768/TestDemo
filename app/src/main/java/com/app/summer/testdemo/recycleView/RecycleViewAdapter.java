package com.app.summer.testdemo.recycleView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.summer.testdemo.R;

import java.util.List;

/**
 * @author jingwei
 * date: 2019/8/7
 * desc:
 */
public class RecycleViewAdapter extends BaseRecycleViewAdapter<RecycleViewDataBean> {

    RecycleViewAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_recycle_view;
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, RecycleViewDataBean itemData, int position) {

        TextView tv_name = holder.findViewById(R.id.tv_name);
        TextView tv_age = holder.findViewById(R.id.tv_age);

        tv_name.setText(itemData.name);
        tv_age.setText("" + itemData.age);
    }


}
