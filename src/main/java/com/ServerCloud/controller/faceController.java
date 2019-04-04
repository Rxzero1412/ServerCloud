package com.ServerCloud.controller;

import com.ServerCloud.model.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


@Controller
public class faceController {

    @Resource
    private Result result;

    @RequestMapping("/face/uploadfile")
    @ResponseBody      //把回传类转换成json
    public Result uploadPhone(@RequestParam(value="file",required=false)MultipartFile file
            ,HttpServletRequest request) throws IllegalStateException, IOException {
        String path=uploadFile(file, request);
        Result result=new Result();
        result.setCode("200");
        result.setPath(path);
        result.setMessage("上传成功");
        return result;
    }

    /**
     * 上传
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    private String  uploadFile(MultipartFile file,HttpServletRequest request) throws IOException {
        String path=request.getSession().getServletContext().getRealPath("upload");
        String fileName=file.getOriginalFilename();
        File targetFile=new File(path,fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        file.transferTo(targetFile);
        return  targetFile.getAbsolutePath();
    }
}
