package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.EUDataGridResult;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.service.ContentService;
import com.taotao.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 杨波 on 2017/3/19.
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private TbContentMapper contentMapper;
    /**查询列表list*/
    @Override
    public EUDataGridResult getContentList(Integer page, Integer rows, Long categoryId) {
        //根据分类id查询列表
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        List<TbContent> tbContents = contentMapper.selectByExample(example);
        //分页
        PageHelper.startPage(page,rows);
        EUDataGridResult result = new EUDataGridResult();
        //set列表
        result.setRows(tbContents);
        //记录总数
        PageInfo<TbContent> pageInfo = new PageInfo<>(tbContents);
        //set总数
        result.setTotal(pageInfo.getTotal());

        return result;
    }
    /**添加内容*/
    @Override
    public TaotaoResult insertContent(TbContent content) {
        //不全pojo
        content.setCreated(new Date());
        content.setUpdated(new Date());
        contentMapper.insert(content);

        //添加缓存同步逻辑
        try {
            HttpClientUtil.doGet("http://localhost:8081/rest" + "/cache/sync/content/" + content.getCategoryId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return TaotaoResult.ok();
    }


}
