package com.llt.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llt.seckill.exception.GlobalException;
import com.llt.seckill.mapper.UserMapper;
import com.llt.seckill.pojo.User;
import com.llt.seckill.service.IUserService;
import com.llt.seckill.util.MD5Util;
import com.llt.seckill.util.ValidatorUtil;
import com.llt.seckill.vo.loginvo;
import com.llt.seckill.vo.RespBean;
import com.llt.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author llt796
 * @since 2023-05-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;


    /**
     * 登录
     * @param loginvo
     * @return
     */
    @Override
    public RespBean doLogin(loginvo loginvo) {
        String mobile=loginvo.getMobile();
        String password=loginvo.getPassword();
        /**

        //参数校验
        if(StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password))
        {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        if(!ValidatorUtil.isMobile(mobile))
        {
            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
        }*/

        //根据手机号获取用户
        User user = userMapper.selectById(mobile);
        if(null==user)
        {
            //return RespBean.error(RespBeanEnum.LOGIN_ERROR);
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        //判断密码是否正确
        if(!MD5Util.formPassToDBPass(password,user.getSalt()).equals(user.getPassword()))
        {
            //return RespBean.error(RespBeanEnum.LOGIN_ERROR);
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        return RespBean.success();
    }
}
