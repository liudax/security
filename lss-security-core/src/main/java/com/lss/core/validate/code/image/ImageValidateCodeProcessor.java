package com.lss.core.validate.code.image;

import com.lss.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * @author Magic
 * @date 14:20 2017/11/14
 * @description
 */
@Component
public class ImageValidateCodeProcessor extends AbstractValidateCodeProcessor<ImageCode>{

    @Override
    public void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        ImageIO.write(imageCode.getImage(),"jpeg",request.getResponse().getOutputStream());
    }
}
