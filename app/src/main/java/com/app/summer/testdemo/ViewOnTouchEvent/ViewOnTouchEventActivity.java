package com.app.summer.testdemo.ViewOnTouchEvent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.app.summer.testdemo.R;

public class ViewOnTouchEventActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    private Button btnTest1;
    private Button btnTest2;
    private WindowManager.LayoutParams layoutParams;
    private WindowManager windowManager;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
                btnTest1.performClick();
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_on_touch_event);


        btnTest1 = findViewById(R.id.btn_test);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    Message msg = handler.obtainMessage();
                    msg.what = 100;
                    handler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

        initView();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initView() {
        Button btn_onTouch = findViewById(R.id.test_on_touch_btn);
        LinearLayout ll_onTouch = findViewById(R.id.test_on_touch_ll);
        // 重写父布局的onTouch()方法
        ll_onTouch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        btn_onTouch.setOnClickListener(this);
        ll_onTouch.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.test_on_touch_btn:
                Toast.makeText(this, "点击了按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.test_on_touch_ll:
                Toast.makeText(this, "点击了布局", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //布局文件中的按钮写入的点击事件onButtonClick，用于控制“滑动按钮的显示”
    public void onButtonClick(View view) {
        if (view.getId() == R.id.btn_test) {
            if (!Settings.canDrawOverlays(this)) {
                //启动Activity让用户授权
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, 1010);
            } else {
                btnTest2 = new Button(this);
                btnTest2.setText("滑动按钮");
                layoutParams = new WindowManager.LayoutParams(
                        WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.WRAP_CONTENT,
                        0, 0,//0,0 分别是type和flags参数，在后面分别配置了
                        PixelFormat.TRANSPARENT);
                layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
                //申明以下type时 需要申请权限android.permission.SYSTEM_ALERT_WINDOW
                layoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
                layoutParams.gravity = Gravity.LEFT | Gravity.TOP;
                layoutParams.x = 100;
                layoutParams.y = 300;
                windowManager.addView(btnTest2, layoutParams);
                btnTest2.setOnTouchListener(this);
            }

        }

    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                break;
            }
            /*依旧是是从event事件中拿到坐标 为了实现动态移动的按钮 必须动态的创建按钮 指定按钮的坐标*/
            case MotionEvent.ACTION_MOVE:
                layoutParams.x = rawX;
                layoutParams.y = rawY;
                windowManager.updateViewLayout(btnTest2, layoutParams);
                break;
            case MotionEvent.ACTION_UP: {
                break;
            }
        }
        return false;

    }


    @Override
    protected void onDestroy() {
        try {
            windowManager.removeView(btnTest2);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }
}
