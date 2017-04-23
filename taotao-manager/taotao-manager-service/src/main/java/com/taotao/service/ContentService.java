package com.taotao.service;

import com.taotao.pojo.EUDataGridResult;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

/**
 * Created by 杨波 on 2017/3/19.
 */
public interface ContentService {
    TaotaoResult insertContent(TbContent content);
    EUDataGridResult getContentList(Integer page, Integer rows, Long categoryId);
}
