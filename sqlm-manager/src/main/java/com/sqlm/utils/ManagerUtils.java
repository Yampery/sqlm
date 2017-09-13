package com.sqlm.utils;

import com.sqlm.pojo.TUser;
import org.apache.commons.lang.StringUtils;

/**
 * @decription ManagerUtils
 * <p>专用处理用户相关工具</p>
 * @author Yampery
 * @date 2017/9/13 11:05
 */
public class ManagerUtils {

    /**
     * 校验用户注册数据
     * @param user 用户
     * @return 返回校验结果，没有问题则返回空字符串
     */
    public static String checkRegister(TUser user) {

        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String mobile = user.getMobile();

        return "";
    }
}
