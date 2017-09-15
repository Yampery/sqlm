package com.sqlm.controller;

import com.sqlm.pojo.ResponsePojo;
import com.sqlm.pojo.TUser;
import com.sqlm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @decription UserController
 * <p>关于用户的Controller</p>
 * @author Yampery
 * @date 2017/9/13 10:44
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource private UserService userService;

    /**
     * 用户注册
     * @param user 用户
     * @return
     */
    @RequestMapping("/register")
    public ResponsePojo register(TUser user) {

        try {
            userService.save(user);
        } catch (Exception e) {

            logger.error(e.getMessage());
            return ResponsePojo.error("注册失败！");
        }

        logger.info("注册成功==> " + user);
        // 校验用户数据
        return ResponsePojo.ok();
    }
}
