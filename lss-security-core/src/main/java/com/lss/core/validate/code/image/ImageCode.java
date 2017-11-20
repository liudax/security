package com.lss.core.validate.code.image;

import com.lss.core.validate.code.ValidateCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author Magic
 * @date 17:00 2017/11/3
 * @description
 */
public class ImageCode extends ValidateCode {

    private BufferedImage image;

    public ImageCode(BufferedImage image,String code,LocalDateTime expireTime){
        super(code,expireTime);
        this.image = image;

    }

    public ImageCode(BufferedImage image,String code,int expireInt){
        super(code,expireInt);
        this.image = image;
    }



    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
