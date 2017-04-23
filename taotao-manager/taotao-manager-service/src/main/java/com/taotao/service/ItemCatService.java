package com.taotao.service;

import com.taotao.pojo.EUTreeNode;

import java.util.List;

/**
 * Created by 杨波 on 2017/3/15.
 */
public interface ItemCatService {
    List<EUTreeNode> getCatList(Long parentId);
}
