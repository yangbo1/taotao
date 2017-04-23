package com.taotao.rest.service;

import com.taotao.pojo.TbContent;

import java.util.List;

/**
 * Created by 杨波 on 2017/3/19.
 */
public interface ContentService {
    List<TbContent> getContentList(long contentCid);
}
