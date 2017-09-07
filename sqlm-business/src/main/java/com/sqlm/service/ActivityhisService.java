package com.sqlm.service;

import com.sqlm.pojo.TActivityhis;

import java.util.List;
import java.util.Map;

/**
 * @decription ActivityhisService
 * <p>活动历史相关服务</p>
 * @author Yampery
 * @date 2017/9/7 16:48
 */
public interface ActivityhisService {

    /**
     * 按条件查询活动历史表
     * @param map
     * @return
     */
    List<TActivityhis> queryList(Map<String, Object> map);

    void save(TActivityhis activityhis);
}
