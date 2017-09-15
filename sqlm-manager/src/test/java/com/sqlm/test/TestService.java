package com.sqlm.test;

import com.sqlm.pojo.TUser;
import com.sqlm.service.UserService;
import com.sqlm.utils.TestSupport;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @decription TestService
 * <p>测试服务</p>
 * @author Yampery
 * @date 2017/9/13 15:00
 */
public class TestService extends TestSupport {

    @Resource private UserService userService;

    @Test
    public void testUserService() {

        TUser user = new TUser();
        user.setAuthLevel(127);
        user.setEmail("yampery@163.com");
        user.setUsername("yampery");
        user.setIsActive(1);
        user.setMobile("18792496656");
        user.setPassword("1");
        user.setName("Yampery");
        user.setRegisterTime(new Date());

        userService.save(user);
    }
}
