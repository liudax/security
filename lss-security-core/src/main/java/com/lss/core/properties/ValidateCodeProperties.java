package com.lss.core.properties;

/**
 * @author Magic
 * @date 15:27 2017/11/8
 * @description
 */
public class ValidateCodeProperties {

    private SmsCodeProperties sms = new SmsCodeProperties();

    private ImageCodeProperties image = new ImageCodeProperties();

    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }

    public SmsCodeProperties getSms() {
        return sms;
    }

    public void setSms(SmsCodeProperties sms) {
        this.sms = sms;
    }
}
