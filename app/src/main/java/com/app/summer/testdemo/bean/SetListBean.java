package com.app.summer.testdemo.bean;

/**
 * @author jingwei
 * date: 2019/8/6
 * desc:
 */
public class SetListBean {
    private String carId;
    private int type;

    public SetListBean(String carId, int type) {
        this.carId = carId;
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SetListBean other = (SetListBean) obj;
        if (!carId.equals(other.carId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SetListBean{" +
                "carId='" + carId + '\'' +
                ", type=" + type +
                '}';
    }
}
