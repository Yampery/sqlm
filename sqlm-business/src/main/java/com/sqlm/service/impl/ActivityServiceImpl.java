package com.sqlm.service.impl;

import com.sqlm.dao.TActivityMapper;
import com.sqlm.pojo.TActivity;
import com.sqlm.service.ActivityService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @decription ActivityServiceImpl
 * <p>活动相关服务</p>
 * @author Yampery
 * @date 2017/9/7 17:05
 */
public class ActivityServiceImpl implements ActivityService {

    @Resource private TActivityMapper activityMapper;

    @Override
    public List<TActivity> queryList(Map<String, Object> map) {
        return activityMapper.queryList(map);
    }

    @Override
    public void save(TActivity activity) {
        activityMapper.save(activity);
    }
}
