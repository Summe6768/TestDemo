package com.app.summer.testdemo.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.app.summer.testdemo.R;

public class ServiceActivity extends AppCompatActivity {

    private Intent intent = null;

    private Intent intent2;

    private MyBindService service;
    private ServiceConnection connection = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

    }

    public void onClickService(View view) {
        switch (view.getId()) {
            /**
             * 启动形式
             */
            case R.id.btnStartService:
                if (intent == null) {
                    intent = new Intent(ServiceActivity.this, MyStartService.class);
                    Log.e("TAG", "intent...............: " );
                }
                startService(intent);
                break;
            case R.id.btnStopService:
                if (intent != null) {
                    stopService(intent);
                }
                break;
            /**
             * 绑定形式
             */
            case R.id.btnBindService:

                if (connection == null) {
                    connection = new ServiceConnection() {

                        @Override//当启动源跟Service成功连接后会调用这个方法
                        public void onServiceConnected(ComponentName name, IBinder binder) {
                            service = ((MyBindService.MyBind) binder).getService();
                        }

                        @Override//当启动源跟Service的连接意外丢失的时候会调用这个方法
                        //比如当Service崩溃了，或者是被强行杀死
                        public void onServiceDisconnected(ComponentName name) {

                        }

                    };
                }

                intent2 = new Intent(ServiceActivity.this, MyBindService.class);
                bindService(intent2, connection, Service.BIND_AUTO_CREATE);
                break;
            case R.id.btnPlay:
                if (connection != null) {
                    service.Play();
                }
                break;
            case R.id.btnPause:
                if (connection != null) {
                    service.Pause();
                }
                break;
            case R.id.btnNext:
                if (connection != null) {
                    service.Next();
                }
                break;
            case R.id.btnPervious:
                if (connection != null) {
                    service.Pervious();
                }
                break;
            case R.id.btnUnBind:
                if (connection != null) {
                    unbindService(connection);
                    connection = null;
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (intent != null) {
            stopService(intent);
        }

        if (connection != null) {
            unbindService(connection);
        }

    }
}
