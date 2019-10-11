package com.app.summer.testdemo.recycleView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingwei
 * date: 2019/8/7
 * desc: RecycleViewAdapter 基类
 */
public abstract class BaseRecycleViewAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    private Context context;

    public List<T> dataList = new ArrayList<>();

    private OnItemClickListener<T> onItemClickListener;

    private OnItemLongClickListener<T> onItemLongClickListener;

    /**
     * 构造方法
     *
     * @param context
     */
    BaseRecycleViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(getLayoutId(), viewGroup, false);
        return new BaseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final BaseViewHolder holder, int position) {

        if (onItemClickListener != null) {
            holder.getItemView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder, dataList.get(position), position);
                }
            });
        }

        if (onItemLongClickListener != null) {
            holder.getItemView().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int position = holder.getLayoutPosition();
                    onItemLongClickListener.onItemLongClick(holder, dataList.get(position), position);
                    return true;
                }
            });
        }

        bindViewHolder(holder, dataList.get(position), position);

    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    /**
     * 获取xml
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 绑定 UI and 数据
     *
     * @param holder
     * @param itemData
     * @param position
     */
    public abstract void bindViewHolder(BaseViewHolder holder, T itemData, int position);

    /**
     * 设置数据
     *
     * @param dataList
     */
    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    /**
     * 添加数据
     *
     * @param data
     */
    public void addData(List<T> data) {
        dataList.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 删除数据
     * @param position 删除第几条数据
     */
    public void removeData(int position) {
        dataList.remove(position);
        notifyDataSetChanged();
    }

    /**
     * 清空数据
     */
    public void clearAllData(){
        dataList.clear();
        notifyDataSetChanged();
    }

    /**
     * 点击事件
     *
     * @param <T>
     */
    public interface OnItemClickListener<T> {
        void onItemClick(BaseViewHolder holder, T t, int position);
    }

    /**
     * 长按事件
     *
     * @param <T>
     */
    public interface OnItemLongClickListener<T> {
        void onItemLongClick(BaseViewHolder holder, T t, int position);
    }

    /**
     * 点击事件 set方法
     *
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * 长按事件 set方法
     *
     * @param onItemLongClickListener
     */
    public void setOnItemLongClickListener(OnItemLongClickListener<T> onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }


}
