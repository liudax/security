package com.lss.security.browser.support;

/**
 * @author Magic
 * @date 11:02 2017/11/3
 * @description
 */
public class SimpleResponse {

    private Object content;


    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
