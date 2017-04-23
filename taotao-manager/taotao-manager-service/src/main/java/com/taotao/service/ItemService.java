package com.taotao.service;

import com.taotao.pojo.EUDataGridResult;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * Created by 杨波 on 2017/3/14.
 */
public interface ItemService {
    TbItem getItemById(Long itemId);

    EUDataGridResult getItemList(Integer page, Integer rows);

    TaotaoResult creatItem(TbItem item, String desc, String itemParam) throws Exception;
}
