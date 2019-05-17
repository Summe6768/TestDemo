package com.app.summer.testdemo.sqlite2.utils;

/**
 * @author: Summer
 * @date: 2019/5/16
 */
public class Bean {

    private int _id;
    private String text;

    public Bean(int _id, String text) {
        this._id = _id;
        this.text = text;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "_id=" + _id +
                ", text='" + text + '\'' +
                '}';
    }
}
