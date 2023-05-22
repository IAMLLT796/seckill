package com.llt.seckill.vo;

import com.llt.seckill.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 登录参数
 * @Author llt
 * @Date 2023-05-09-23:05
 **/
@Data
public class loginvo {
    @NotNull
    @IsMobile
    private String mobile;
    @NotNull
    @Length(min=2)
    private String password;
}
