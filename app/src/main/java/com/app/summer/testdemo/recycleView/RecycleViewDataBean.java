package com.app.summer.testdemo.recycleView;

/**
 * @author jingwei
 * date: 2019/8/7
 * desc:
 */
public class RecycleViewDataBean {

    public String name;
    public int age;

    public RecycleViewDataBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "RecycleViewDataBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
