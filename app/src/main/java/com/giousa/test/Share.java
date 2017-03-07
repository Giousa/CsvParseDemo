package com.giousa.test;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2017/3/7
 * Time:下午8:37
 */

public class Share {

    private String name;
    private float value;
    private float min;
    private float max;

    public Share(String name, float value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "Share{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
