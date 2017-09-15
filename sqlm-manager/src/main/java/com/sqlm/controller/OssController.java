package com.sqlm.controller;

import com.alibaba.fastjson.JSON;
import com.sqlm.exception.SQException;
import com.sqlm.oss.CloudStorageConfig;
import com.sqlm.oss.OSSFactory;
import com.sqlm.pojo.ResponsePojo;
import com.sqlm.pojo.SysOssPojo;
import com.sqlm.service.SysConfigService;
import com.sqlm.service.SysOssService;
import com.sqlm.utils.Constant;
import com.sqlm.utils.PageUtils;
import com.sqlm.utils.QueryParams;
import com.sqlm.validator.ValidatorUtils;
import com.sqlm.validator.group.AliyunGroup;
import com.sqlm.validator.group.QcloudGroup;
import com.sqlm.validator.group.QiniuGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @decription OssController
 * <p>云存储文件上传接口</p>
 * @author Yampery
 * @date 2017/9/14 10:30
 */
@RestController
@RequestMapping("/sys/oss")
public class OssController {
	@Autowired
	private SysOssService sysOssService;
    @Autowired
    private SysConfigService sysConfigService;

    private final static String KEY = Constant.CLOUD_STORAGE_CONFIG_KEY;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public ResponsePojo list(@RequestParam Map<String, Object> params){
		//查询列表数据
		QueryParams query = new QueryParams(params);
		List<SysOssPojo> sysOssList = sysOssService.queryList(query);
		int total = sysOssService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysOssList, total, query.getLimit(), query.getPage());
		
		return ResponsePojo.ok(pageUtil);
	}


    /**
     * 云存储配置信息
     */
    @RequestMapping("/config")
    public ResponsePojo config(){
        CloudStorageConfig config = sysConfigService.getConfigObject(KEY, CloudStorageConfig.class);

        return ResponsePojo.ok(config);
    }


	/**
	 * 保存云存储配置信息
	 */
	@RequestMapping("/saveConfig")
	public ResponsePojo saveConfig(@RequestBody CloudStorageConfig config){
		//校验类型
		ValidatorUtils.validateEntity(config);

		if(config.getType() == Constant.CloudService.QINIU.getValue()){
			//校验七牛数据
			ValidatorUtils.validateEntity(config, QiniuGroup.class);
		}else if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
			//校验阿里云数据
			ValidatorUtils.validateEntity(config, AliyunGroup.class);
		}else if(config.getType() == Constant.CloudService.QCLOUD.getValue()){
			//校验腾讯云数据
			ValidatorUtils.validateEntity(config, QcloudGroup.class);
		}
		

        sysConfigService.updateValueByKey(KEY, JSON.toJSONString(config));

		return ResponsePojo.ok();
	}
	

	/**
	 * 上传文件
	 */
	@RequestMapping("/upload")
	public ResponsePojo upload(@RequestParam("file") MultipartFile file) throws Exception {
		if (file.isEmpty()) {
			throw new SQException("上传文件不能为空");
		}

		//上传文件
		String url = OSSFactory.build().upload(file.getBytes());
		String type = file.getContentType();
		String orignialName = file.getOriginalFilename();
		//保存文件信息
		SysOssPojo ossEntity = new SysOssPojo();
		ossEntity.setUrl(url);
		ossEntity.setCreateDate(new Date());
		sysOssService.save(ossEntity);

		return ResponsePojo.ok(url);
	}


	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public ResponsePojo delete(@RequestBody Long[] ids){
		sysOssService.deleteBatch(ids);

		return ResponsePojo.ok();
	}

}
