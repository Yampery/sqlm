package com.sqlm.service;

import com.sqlm.pojo.SysOssPojo;

import java.util.List;
import java.util.Map;

/**
 * @decription SysOssService
 * <p>云存储文件上传服务</p>
 * @author Yampery
 * @date 2017/9/14 10:24
 */
public interface SysOssService {
	
	SysOssPojo queryObject(Long id);
	
	List<SysOssPojo> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysOssPojo sysOss);
	
	void update(SysOssPojo sysOss);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
