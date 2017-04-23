package com.taotao.portal.service;

import com.taotao.pojo.TbUser;

/**
 * Created by 杨波 on 2017/4/17.
 */
public interface UserService {
    TbUser getUserByToken(String token);
}
