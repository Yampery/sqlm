package com.sqlm.test;

import com.sqlm.pojo.TActivity;
import com.sqlm.service.ActivityService;
import com.sqlm.utils.JsonUtils;
import com.sqlm.utils.TestSupport;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @decription TestService
 * <p></p>
 * @author Yampery
 * @date 2017/9/7 17:20
 */
public class TestService extends TestSupport {

    @Resource private ActivityService activityService;
    @Test
    public void testActivityService() {
        TActivity activity = new TActivity();
        activity.setActivityName("测试");
        activity.setPublishTime(new Date());
        activity.setPublishUnit("测试");
        activity.setPublishUser("yam");
        activity.setPushLevel(0);
        String info = JsonUtils.objectToJson(activity);
        activity.setActivityInfo(info);

        activityService.save(activity);

        System.out.println(activity);
    }
}
