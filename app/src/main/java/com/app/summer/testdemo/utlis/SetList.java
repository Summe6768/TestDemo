package com.app.summer.testdemo.utlis;

import java.util.LinkedList;

/**
 * 自定义有序且不重复的集合
 */

public class SetList<T> extends LinkedList<T> {
	@Override
	public boolean add(T object) {
		if (size() == 0) {
			return super.add(object);
		} else {
			int count = 0;
			for (T t : this) {
				if (t.equals(object)) {
					count++;
					break;
				}
			}
			if (count == 0) {
				return super.add(object);
			} else {
				return false;
			}
		}
	}
}
