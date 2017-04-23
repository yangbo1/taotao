package com.taotao.service.impl;

import com.taotao.pojo.EUTreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杨波 on 2017/3/15.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Override
    public List<EUTreeNode> getCatList(Long parentId) {
        //创建查询条件
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //根据条件查询
        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
        List<EUTreeNode> resultList = new ArrayList<>();
        //把查询到的列表转换成treeNodeList
        for (TbItemCat tbItemCat:list) {
            EUTreeNode node =new EUTreeNode();
            //叶子节点id
            node.setId(tbItemCat.getId());
            //叶子节点名称
            node.setText(tbItemCat.getName());
            //如果不是叶子节点就是closed，叶子节点就是open。Closed的节点点击后会在此发送请求查询子项目。
            node.setState(tbItemCat.getIsParent()?"closed":"open");
            resultList.add(node);
        }
        return resultList;
    }
}
