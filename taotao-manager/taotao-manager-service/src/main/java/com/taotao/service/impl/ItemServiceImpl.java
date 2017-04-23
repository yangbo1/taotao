package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.*;
import com.taotao.service.ItemService;
import com.taotao.mapper.TbItemMapper;
import com.taotao.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 杨波 on 2017/3/14.
 */
@Service
public class ItemServiceImpl implements ItemService {
    /**根据id查询商品*/
    @Autowired
    private TbItemMapper itemMapper;
    @Autowired
    private TbItemDescMapper itemDescMapper;
    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;
    @Override
    public TbItem getItemById(Long itemId) {
        //查询条件
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> tbItemList = itemMapper.selectByExample(example);
        if (tbItemList != null && tbItemList.size() > 0){
            TbItem tbItem = tbItemList.get(0);
            return tbItem;
        }
        return null;
    }
    /**查询商品列表*/
    @Override
    public EUDataGridResult getItemList(Integer page, Integer rows) {
        TbItemExample example = new TbItemExample();
        //分页
        PageHelper.startPage(page,rows);
        List<TbItem> tbItemList = itemMapper.selectByExample(example);
        EUDataGridResult result = new EUDataGridResult();
        //set列表
        result.setRows(tbItemList);
        //记录总数
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItemList);
        //set总数
        result.setTotal(pageInfo.getTotal());
        return result;
    }
    /**添加商品*/
    @Override
    public TaotaoResult creatItem(TbItem item, String desc, String itemParam) throws Exception{
        //添加item剩余的信息
        //生成id
        Long itemId = IDUtils.genItemId();
        item.setId(itemId);
        // '商品状态，1-正常，2-下架，3-删除',
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //插入数据库
        itemMapper.insert(item);
        //添加商品描述信息
        TaotaoResult result = insertItemDesc(itemId, desc);
        if (result.getStatus() != 200) {
            throw new Exception();
        }
        //添加规格参数
        result = insertItemParamItem(itemId, itemParam);
        if (result.getStatus() != 200) {
            throw new Exception();
        }
        return TaotaoResult.ok();

    }
    /**添加商品描述*/
    private TaotaoResult insertItemDesc(Long itemId, String desc) {
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setUpdated(new Date());
        itemDesc.setCreated(new Date());
        itemDescMapper.insert(itemDesc);
        return TaotaoResult.ok();
    }
    /**添加商品规格参数到数据库*/
    private TaotaoResult insertItemParamItem(Long itemId, String itemParam){
        //创建pojo
        TbItemParamItem itemParamItem = new TbItemParamItem();
        itemParamItem.setItemId(itemId);
        itemParamItem.setParamData(itemParam);
        itemParamItem.setCreated(new Date());
        itemParamItem.setUpdated(new Date());
        //向tb_item_param_item表中写入规格数据
        itemParamItemMapper.insert(itemParamItem);
        return TaotaoResult.ok();
    }
}
