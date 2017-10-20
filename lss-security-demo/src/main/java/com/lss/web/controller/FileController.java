package com.lss.web.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Magic
 * @date 19:53 2017/10/16
 * @description
 */
@RestController
public class FileController {

    final static String FOLDER =  "D:\\workspace\\idea\\security\\lss-security-demo\\src\\main\\java\\com\\lss\\web\\controller";

    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        File localFile = new File(FOLDER,System.currentTimeMillis()+".txt");
        file.transferTo(localFile);
        return "上传成功";
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request , HttpServletResponse response) throws Exception {


        File file = new File(FOLDER,id+".txt");
        try(InputStream in = new FileInputStream(file);
            OutputStream out = response.getOutputStream()){
            response.setContentType("application/x-download");
            response.setHeader("Content-Disposition","attachment;filename=down.txt");
            IOUtils.copy(in,out);
            out.flush();
        }


    }

    @RequestMapping("/version")
    public Map<String,Object> getProperties() throws Exception {

        final  String VERSION_ID = "app_version_id";
        final  String VERSION_FORCE = "app_update_force";
        final  String VERSION_DOWNLOAD_URL = "app_download_url";
        final  String FILE = "app-version.properties";
        final  String DESCRIPTION = "app_description";

        Properties properties = new Properties();
        Map out = new HashMap();
        try (InputStream in =FileController.class.getClassLoader().getResourceAsStream("app-version.properties") ){
            properties.load(new InputStreamReader(in,"gbk"));
        } catch (Exception e) {

        }
        out.put(VERSION_ID,properties.getProperty(VERSION_ID));
        try {
            out.put(DESCRIPTION,new String(properties.getProperty(DESCRIPTION).getBytes("gbk")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        out.put(DESCRIPTION,properties.getProperty(DESCRIPTION));
        out.put(VERSION_FORCE,properties.getProperty(VERSION_FORCE));
        out.put(VERSION_DOWNLOAD_URL,properties.getProperty(VERSION_DOWNLOAD_URL));

        return out;
    }
}
