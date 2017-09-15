package com.sqlm.service.impl;

import com.sqlm.dao.TUserMapper;
import com.sqlm.pojo.TUser;
import com.sqlm.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @decription UserServiceImpl
 * <p></p>
 * @author Yampery
 * @date 2017/9/13 10:57
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource private TUserMapper userMapper;

    @Override
    public void save(TUser user) {
        if (StringUtils.isNotBlank(user.getPassword()))
            user.setPassword(new Sha256Hash(user.getPassword()).toHex());
        // 注册默认为普通用户
        user.setAuthLevel(1);
        user.setRegisterTime(new Date());
        user.setIsActive(1);
        userMapper.save(user);
    }
}
