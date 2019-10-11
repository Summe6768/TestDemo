package com.app.summer.testdemo.recycleView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.app.summer.testdemo.R;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

public class RecycleViewActivity extends AppCompatActivity{

    private RefreshLayout refreshLayout ;
    private RecyclerView rvView;
    private RecycleViewAdapter adapter;

    private ArrayList<RecycleViewDataBean> arrayList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        initView();

    }

    private void initView() {

        refreshLayout  = findViewById(R.id.refreshLayout);
        rvView = findViewById(R.id.rvView);


        arrayList.add(new RecycleViewDataBean("张三", 2));
        arrayList.add(new RecycleViewDataBean("李四", 5));
        arrayList.add(new RecycleViewDataBean("王五", 55));
        arrayList.add(new RecycleViewDataBean("赵丽", 88));


        adapter = new RecycleViewAdapter(this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        rvView.setLayoutManager(manager);
        rvView.setAdapter(adapter);
        //添加Android自带的分割线
        rvView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        adapter.setDataList(arrayList);




        adapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener<RecycleViewDataBean>() {
            @Override
            public void onItemClick(BaseViewHolder holder, RecycleViewDataBean recycleViewDataBean, int position) {
                Log.e("TAG", "onItemClick :" + recycleViewDataBean.name);
                Log.e("TAG", "onItemClick position:" + position);
            }
        });

        adapter.setOnItemLongClickListener(new BaseRecycleViewAdapter.OnItemLongClickListener<RecycleViewDataBean>() {
            @Override
            public void onItemLongClick(BaseViewHolder holder, RecycleViewDataBean recycleViewDataBean, int position) {
                adapter.addData(arrayList);
                //adapter.removeData(position);
            }
        });

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });

    }



}
