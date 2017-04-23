package com.taotao.service;

import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * Created by 杨波 on 2017/3/17.
 */
public interface ItemParamService {
    TaotaoResult getItemParamByCid(long cid);
    TaotaoResult insertItemParam(TbItemParam itemParam);

}
