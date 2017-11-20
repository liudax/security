package com.lss.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author Magic
 * @date 17:05 2017/11/3
 * @description
 */

@RestController
@RequestMapping("/code")
public class ValidateController {

    @Autowired
    private Map<String,ValidateCodeProcessor> validateCodeProcessorMap;

    @GetMapping("/{type}")
    public void create(HttpServletRequest request,HttpServletResponse response,@PathVariable String type) throws Exception {
        validateCodeProcessorMap.get(type+"ValidateCodeProcessor").create(new ServletWebRequest(request,response));
    }

}
