package com.taotao.service.impl;

import com.taotao.service.PictureService;
import com.taotao.utils.IDUtils;
import com.taotao.utils.SFTPUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 杨波 on 2017/3/16.
 */
@Service
public class PictureServiceImpl implements PictureService {
    @Override
    public Map uploadPicture(MultipartFile uploadFile) {
        Map resultMap =new HashMap();

        try {
            //取原文件名生成文件名
            String oldName = uploadFile.getOriginalFilename();
            String newName = IDUtils.genImageName() + oldName.substring(oldName.indexOf("."));
            //上传图片
            SFTPUtil sftpUtil = new SFTPUtil();

            sftpUtil.setInputStream((FileInputStream) uploadFile.getInputStream());
            sftpUtil.setRemote(newName);
            sftpUtil.setRemotePath("/usr/local/nginx/html/images");
            Boolean result = sftpUtil.uploadFile();

            if(!result) {
                resultMap.put("error", 1);
                resultMap.put("message", "文件上传失败");
                return resultMap;
            }
            resultMap.put("error", 0);
            resultMap.put("url", "http://192.168.203.128/images/" + newName);
            return resultMap;

        } catch (IOException e) {
            resultMap.put("error", 1);
            resultMap.put("message", "文件上传发生异常");
            return resultMap;
        }
        }

}
