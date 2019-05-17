package com.app.summer.testdemo.sqlite2;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.app.summer.testdemo.R;
import com.app.summer.testdemo.sqlite.utils.Constant;
import com.app.summer.testdemo.sqlite.utils.DbManger;
import com.app.summer.testdemo.sqlite2.utils.Bean;
import com.app.summer.testdemo.sqlite2.utils.Constant2;
import com.app.summer.testdemo.sqlite2.utils.MySQLiteHelper2;
import com.app.summer.testdemo.sqlite2.utils.Bean;

import java.util.ArrayList;
import java.util.List;

public class MySQLiteActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edInsert, edUpData;
    private Button btnInsert, btnUpData, btnDel, btnQuery;
    private LinearLayout ll;

    private String strEdInsert;
    private String strEdUpData;

    private ListView listView;

    private MySQLiteHelper2 helper2;
    private SQLiteDatabase db;

    private int tobleNum;//当前控件加载数据的总条目
    private int pageSize = 15;//每页条数
    private int pageNum;//总页码


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sqlite);

        helper2 = DbManger.getInstance2(this);

        initView();
        initOnClick();
    }


    private void initView() {
        edInsert = findViewById(R.id.edInsert);
        edUpData = findViewById(R.id.edUpData);
        btnInsert = findViewById(R.id.btnInsert);
        btnUpData = findViewById(R.id.btnUpData);
        btnDel = findViewById(R.id.btnDel);
        btnQuery = findViewById(R.id.btnQuery);
        ll = findViewById(R.id.ll);
        listView = findViewById(R.id.listView);


    }

    private void initOnClick() {
        btnInsert.setOnClickListener(this);
        btnUpData.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnQuery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnInsert:
                //插入
                strEdInsert = edInsert.getText().toString();

                db = helper2.getWritableDatabase();
                db.delete(Constant2.TABLE_NAME, null, null);
                db.beginTransaction();
                for (int i = 0; i <= 30; i++) {
                    String sql = "insert into " + Constant2.TABLE_NAME + " values(" + i + ",'张三" + i + "')";
                    db.execSQL(sql);
                }
                db.setTransactionSuccessful();
                db.endTransaction();
                db.close();

//                if (strEdInsert != null && !"".equals(strEdInsert)) {
//                    db = helper2.getWritableDatabase();
//                    //开始事务
//                    db.beginTransaction();
//                    //db.execSQL("delete from " + Constant2.TABLE_NAME + "");
//
//                    ContentValues contentValues = new ContentValues();
//                    contentValues.put(Constant2._ID, 1);
//                    contentValues.put(Constant2.TEXT, strEdInsert);
//
//                    long l = db.insert(Constant2.TABLE_NAME, null, contentValues);
//
//                    //提交事务
//                    db.setTransactionSuccessful();
//
//                    //关闭事务
//                    db.endTransaction();
//
//                    if (l > 0) {
//                        Toast.makeText(this, "插入成功", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(this, "插入失败", Toast.LENGTH_SHORT).show();
//                    }
//                    db.close();
//
//                } else {
//                    Toast.makeText(this, "不能输入空的", Toast.LENGTH_SHORT).show();
//                }
                break;
            case R.id.btnUpData:
                //修改
                strEdUpData = edUpData.getText().toString();
                if (strEdUpData != null && !"".equals(strEdUpData)) {
                    db = helper2.getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Constant2.TEXT, strEdUpData);
                    int intUpData = db.update(Constant2.TABLE_NAME, contentValues, Constant2._ID + "=?", new String[]{"1"});
                    if (intUpData > 0) {
                        Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "修改失败", Toast.LENGTH_SHORT).show();
                    }
                    db.close();
                }
                break;
            case R.id.btnDel:
                //删除
                db = helper2.getWritableDatabase();
                int intDel = db.delete(Constant2.TABLE_NAME, Constant2._ID + "=?", new String[]{"1"});
                if (intDel > 0) {
                    Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "删除失败", Toast.LENGTH_SHORT).show();
                }
                db.close();
                break;
            case R.id.btnQuery:
                //查询
                db = helper2.getWritableDatabase();
                Cursor cursor = db.query(Constant2.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
                if (cursor.getCount() == 0) {
                    Toast.makeText(this, "数据表是空的", Toast.LENGTH_SHORT).show();
                }

                tobleNum = DbManger.getDataCount(db, Constant2.TABLE_NAME);
                //根据总条目与每页展示数据条目，获取总页数
                pageNum = (int) Math.ceil(tobleNum / (double) pageSize);


//                SimpleCursorAdapter adapter = new SimpleCursorAdapter(
//                        this,
//                        R.layout.item_sqlite,
//                        cursor,
//                        new String[]{Constant2._ID, Constant2.TEXT},
//                        new int[]{R.id.tv_id, R.id.tv_name},
//                        SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
//                listView.setAdapter(adapter);

                MyCursorAdapter myCursorAdapter = new MyCursorAdapter(this, cursor, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
                listView.setAdapter(myCursorAdapter);

//                List<Bean> beanList = dataQuery(cursor);
//                for (Bean bean : beanList){
//                    TextView textView = new TextView(this);
//                    textView.setText(bean.toString());
//                    ll.addView(textView);
//                }
                db.close();
                break;
        }
    }

    public static List<Bean> dataQuery(Cursor cursor) {
        List<Bean> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            String text = cursor.getString(cursor.getColumnIndex(Constant2.TEXT));
            int _id = cursor.getInt(cursor.getColumnIndex(Constant2._ID));

            Bean bean = new Bean(_id, text);
            list.add(bean);
        }
        return list;
    }

    /**
     * 内部类
     */
    public class MyCursorAdapter extends CursorAdapter {


        public MyCursorAdapter(Context context, Cursor c, int flags) {
            super(context, c, flags);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            View view = LayoutInflater.from(MySQLiteActivity.this).inflate(R.layout.item_sqlite, null);
            return view;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView tv_id = view.findViewById(R.id.tv_id);
            TextView tv_name = view.findViewById(R.id.tv_name);

            tv_id.setText(cursor.getInt(cursor.getColumnIndex(Constant2._ID)) + "");
            tv_name.setText(cursor.getString(cursor.getColumnIndex(Constant2.TEXT)));
        }
    }

}
