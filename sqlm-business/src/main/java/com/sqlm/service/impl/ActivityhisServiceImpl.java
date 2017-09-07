package com.sqlm.service.impl;

import com.sqlm.dao.TActivityhisMapper;
import com.sqlm.pojo.TActivityhis;
import com.sqlm.service.ActivityhisService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @decription ActivityhisServiceImpl
 * <p>活动历史相关服务</p>
 * @author Yampery
 * @date 2017/9/7 17:07
 */
public class ActivityhisServiceImpl implements ActivityhisService {

    @Resource private TActivityhisMapper activityhisMapper;
    @Override
    public List<TActivityhis> queryList(Map<String, Object> map) {
        return activityhisMapper.queryList(map);
    }
}