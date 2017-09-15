package com.sqlm.service.impl;

import com.sqlm.dao.SysOssDao;
import com.sqlm.pojo.SysOssPojo;
import com.sqlm.service.SysOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("sysOssService")
public class SysOssServiceImpl implements SysOssService {
	@Autowired
	private SysOssDao sysOssDao;
	
	@Override
	public SysOssPojo queryObject(Long id){
		return sysOssDao.queryObject(id);
	}
	
	@Override
	public List<SysOssPojo> queryList(Map<String, Object> map){
		return sysOssDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysOssDao.queryTotal(map);
	}
	
	@Override
	public void save(SysOssPojo sysOss){
		sysOssDao.save(sysOss);
	}
	
	@Override
	public void update(SysOssPojo sysOss){
		sysOssDao.update(sysOss);
	}
	
	@Override
	public void delete(Long id){
		sysOssDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		sysOssDao.deleteBatch(ids);
	}
	
}
