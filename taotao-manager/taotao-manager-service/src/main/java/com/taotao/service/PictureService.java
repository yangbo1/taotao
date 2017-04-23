package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by 杨波 on 2017/3/16.
 */
public interface PictureService {
    Map uploadPicture(MultipartFile uploadFile);
}
