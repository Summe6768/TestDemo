package com.app.summer.testdemo.handler;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.summer.testdemo.R;

@SuppressLint({"HandlerLeak", "SetTextI18n"})
public class HandlerActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imgView;
    private Button btnDel;


    //return true，通过new Callback可以拦截发送过来的消息
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Toast.makeText(HandlerActivity.this, "哈哈哈", Toast.LENGTH_SHORT).show();
            return false;
        }
    }) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.arg1 == 1) {
                Log.e("TAG", "msg.arg1发送sendMessage成功了:" + msg.arg1);
            }
            if (msg.arg2 == 2) {
                Log.e("TAG", "msg.arg2发送sendMessage成功了:" + msg.arg2);
            }
            Log.e("TAG", "msg.obj发送sendMessage成功了:" + msg.obj);
        }
    };

    private int images[] = {R.mipmap.ic_launcher, R.mipmap.cat, R.mipmap.ic_launcher};
    private int index;

    private MyRunnable myRunnable = new MyRunnable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);


        textView = findViewById(R.id.textView);
        imgView = findViewById(R.id.imgView);
        btnDel = findViewById(R.id.btnDel);

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(myRunnable);
            }
        });

        handler.postDelayed(myRunnable, 1000);

        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);

//                    Message message = new Message();
                    Message message = handler.obtainMessage();
                    message.arg1 = 1;
                    message.arg2 = 2;

                    Person person = new Person();
                    person.age = 11;
                    person.name = "张三";
                    message.obj = person;

                    handler.sendMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                try {
//                    Thread.sleep(1000);
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            textView.setText("哈哈哈");
//                        }
//                    });
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();

    }

    class MyRunnable implements Runnable {
        @Override
        public void run() {
            index++;
            index = index % 3;
            imgView.setImageResource(images[index]);
            handler.postDelayed(myRunnable, 1000);
        }
    }

    class Person {
        public String name;
        public int age;

        @Override
        public String toString() {
            return "name=" + name + "age=" + age;
        }
    }
}
