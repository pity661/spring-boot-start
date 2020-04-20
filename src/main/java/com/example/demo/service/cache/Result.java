package com.example.demo.service.cache;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-09 11:33
 */
public class Result {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Result{" + "value='" + value + '\'' + '}';
    }
}
