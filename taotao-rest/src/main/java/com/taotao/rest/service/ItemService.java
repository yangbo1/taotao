package com.taotao.rest.service;

import com.taotao.pojo.TaotaoResult;

/**
 * Created by 杨波 on 2017/4/7.
 */
public interface ItemService {
    TaotaoResult getItemBaseInfo(long itemId);
    TaotaoResult getItemDesc(long itemId);
    TaotaoResult getItemParam(long itemId);
}
