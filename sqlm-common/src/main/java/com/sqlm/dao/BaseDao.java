package com.sqlm.dao;

import java.util.List;
import java.util.Map;

/**
 * @decription BaseDao
 * <p>常用的数据库操作，其他dao可以继承</p>
 * @author Yampery
 * @date 2017/9/7 15:55
 */
public interface BaseDao<T> {

    void save(T t);

    void save(Map<String, Object> map);

    void saveBatch(List<T> list);

    int update(T t);

    int update(Map<String, Object> map);

    int delete(Object id);

    int delete(Map<String, Object> map);

    int deleteBatch(Object[] id);

    T queryObject(Object id);

    List<T> queryList(Map<String, Object> map);

    List<T> queryAll();

    List<T> queryList(Object id);

    int queryTotal(Map<String, Object> map);

    int queryTotal();
}
