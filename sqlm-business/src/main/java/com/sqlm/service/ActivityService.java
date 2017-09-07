package com.sqlm.service;

import com.sqlm.pojo.TActivity;

import java.util.List;
import java.util.Map;

/**
 * @decription ActivityService
 * <p>活动相关服务</p>
 * @author Yampery
 * @date 2017/9/7 16:47
 */
public interface ActivityService {

    /**
     * 按条件查询活动列表
     * @param map
     * @return
     */
    List<TActivity> queryList(Map<String, Object> map);
}
