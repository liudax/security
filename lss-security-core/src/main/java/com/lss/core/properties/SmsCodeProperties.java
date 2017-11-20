package com.lss.core.properties;

/**
 * @author Magic
 * @date 15:25 2017/11/8
 * @description
 */
public class SmsCodeProperties {


    private int length = 4;

    private int expireIn  = 60;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }
}
