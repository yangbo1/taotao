package com.taotao.controller;

import com.taotao.pojo.EUDataGridResult;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 杨波 on 2017/3/19.
 */
@Controller
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentService contentService;
    /**查询列表list*/
    @RequestMapping("/query/list")
    @ResponseBody
    public EUDataGridResult getContentList(Integer page, Integer rows, Long categoryId){
        EUDataGridResult result = contentService.getContentList(page, rows, categoryId);
        return result;
    }
    /**添加内容*/
    @RequestMapping("/save")
    @ResponseBody
    public TaotaoResult insertContent(TbContent tbContent){
        TaotaoResult result = contentService.insertContent(tbContent);
        return result;
    }
}
