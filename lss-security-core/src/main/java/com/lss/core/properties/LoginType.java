package com.lss.core.properties;

/**
 * @author Magic
 * @date 15:15 2017/11/3
 * @description
 */
public enum LoginType {
    JSON(1,"JSON"),
    REDIRECT(2,"REDIRECT");

    private final int typeNum;

    private final String type;

    public int getTypeNum() {
        return typeNum;
    }

    public String getType() {
        return type;
    }

    LoginType(int typeNum, String type) {
        this.type =type;
        this.typeNum = typeNum;
    }
}
