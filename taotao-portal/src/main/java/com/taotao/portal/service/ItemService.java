package com.taotao.portal.service;

import com.taotao.portal.pojo.ItemInfo;

/**
 * Created by 杨波 on 2017/4/7.
 */
public interface ItemService {
    ItemInfo getItemById(Long itemId);
    String getItemDescById(Long itemId);
    String getItemParam(Long itemId);
}
