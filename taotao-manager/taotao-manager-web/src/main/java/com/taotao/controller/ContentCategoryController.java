package com.taotao.controller;

import com.taotao.pojo.EUTreeNode;
import com.taotao.pojo.TaotaoResult;
import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 杨波 on 2017/3/19.
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
    @Autowired
    private ContentCategoryService contentCategoryService;
    /**显示内容分类列表*/
    @RequestMapping("/list")
    @ResponseBody
    public List<EUTreeNode> getCategoryList(@RequestParam(value = "id",defaultValue = "0") Long parentId) {
        List<EUTreeNode> list = contentCategoryService.getCategoryList(parentId);
        return list;
    }
    /**添加内容分类节点*/
    @RequestMapping("/create")
    @ResponseBody
    public TaotaoResult createContentCategory(Long parentId, String name){
        TaotaoResult result = contentCategoryService.insertContentCategory(parentId,name);
        return result;
    }
    /**删除内容分类节点*/
    @RequestMapping("/delete")
    @ResponseBody
    public TaotaoResult deleteContentCategory(Long parentId, Long id){
        TaotaoResult result = contentCategoryService.deleteContentCategory(parentId,id);
        return result;
    }
    /**重命名节点*/
    @RequestMapping("/update")
    @ResponseBody
    public TaotaoResult updateContentCategory(Long id, String name){
        TaotaoResult result = contentCategoryService.updateContentCategory(id,name);
        return result;
    }
}
