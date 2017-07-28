package com.gzr.util;

/**
 * ${description}
 * Created by GZR
 * 2017-07-06
 */
public enum Constant {
    IMG_CODE("img_code");

    private String value;

    Constant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
