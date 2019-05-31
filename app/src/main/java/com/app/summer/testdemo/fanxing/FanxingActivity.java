package com.app.summer.testdemo.fanxing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.app.summer.testdemo.R;
import com.app.summer.testdemo.fanxing.fanxingclass.Cat;
import com.app.summer.testdemo.fanxing.fanxingclass.Dog;
import com.app.summer.testdemo.fanxing.fanxingclass.ShowObject;
import com.app.summer.testdemo.fanxing.fanxinginterface.Piano;
import com.app.summer.testdemo.fanxing.fanxinginterface.Student;
import com.app.summer.testdemo.fanxing.fanxinginterface.Teacher;
import com.app.summer.testdemo.fanxing.fanxinginterface.Violin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class FanxingActivity extends AppCompatActivity {

    private ArrayList<String> arrayList = new ArrayList<>();

    private LinkedList<String> linkedList = new LinkedList<>();

    private HashSet<String> hashSet = new HashSet<>();

    private HashMap<String, String> hashMap = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fanxing);

        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

        for (int i = 0; i < linkedList.size(); i++) {
            Log.e("TAG", "onCreate arrayList:" + arrayList.get(i));
        }


        linkedList.add("link1");
        linkedList.add("link2");
        linkedList.add("link3");
        linkedList.addFirst("link4");

        for (int i = 0; i < linkedList.size(); i++) {
            Log.e("TAG", "onCreate linkedList:" + linkedList.get(i));
        }

        hashSet.add("hashSet1");
        hashSet.add("hashSet2");
        hashSet.add("hashSet3");
        hashSet.add("hashSet4");
        hashSet.add("hashSet3");
        hashSet.add("hashSet4");
        Iterator<String> iterator = hashSet.iterator();

        while (iterator.hasNext()) {
            String s = iterator.next();
            Log.e("TAG", "onCreate hashSet:" + s);
        }


        hashMap.put("name", "敬畏");
        hashMap.put("age", "22");
        Log.e("TAG", "onCreate hashMap：" + hashMap.get("age"));
        for (String key : hashMap.keySet()) {
            Log.e("TAG", "onCreate for each遍历hashMap:" + hashMap.get(key));
        }


        //泛型类
        ShowObject<Cat> showObject = new ShowObject<>();
        ShowObject<Dog> showObject2 = new ShowObject<>();

        showObject.showMess(new Cat());
        showObject2.showMess(new Dog());

        //泛型接口
        Student student = new Student();
        student.listen(new Piano());

        Teacher teacher = new Teacher();
        teacher.listen(new Violin());


    }
}
