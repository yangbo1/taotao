package com.taotao.service;

import com.taotao.pojo.EUTreeNode;
import com.taotao.pojo.TaotaoResult;

import java.util.List;

/**
 * Created by 杨波 on 2017/3/19.
 */
public interface ContentCategoryService {
    List<EUTreeNode> getCategoryList(long parentId);
    TaotaoResult insertContentCategory(long parentId, String name);
    TaotaoResult deleteContentCategory(long parentId, long id);
    TaotaoResult updateContentCategory(Long id, String name);
}
