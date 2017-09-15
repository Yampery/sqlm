package com.sqlm.dao;

import com.sqlm.pojo.SysConfigPojo;
import org.apache.ibatis.annotations.Param;

/**
 * @decription SysConfigDao
 * <p></p>
 * @author Yampery
 * @date 2017/9/13 17:54
 */
public interface SysConfigDao extends BaseDao<SysConfigPojo> {

    /**
     * 根据key，查询value
     */
    String queryByKey(String paramKey);

    /**
     * 根据key，更新value
     */
    int updateValueByKey(@Param("key") String key, @Param("value") String value);
}
