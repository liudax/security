package com.lss.core.properties;

/**
 * @author Magic
 * @date 14:35 2017/11/3
 * @description
 */
public class BrowserProperties {

    private String loginPage = "/login-page.html";

    private String loginType = LoginType.JSON.getType();

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
