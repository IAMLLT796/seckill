package com.llt.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.llt.seckill.pojo.User;
import com.llt.seckill.vo.loginvo;
import com.llt.seckill.vo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author llt796
 * @since 2023-05-08
 */
public interface IUserService extends IService<User> {
    RespBean doLogin(loginvo loginvo);
}
