package com.sqlm.dao;

import com.sqlm.pojo.TOplog;

public interface TOplogMapper {
    int insert(TOplog record);

    int insertSelective(TOplog record);
}