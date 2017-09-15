package com.sqlm.oss;

import com.sqlm.service.SysConfigService;
import com.sqlm.utils.Constant;
import com.sqlm.utils.SpringContextUtils;

/**
 * @author Yampery
 * @decription <p></p>
 * @date 2017/9/13 15:59
 */
public class OSSFactory {

    private static SysConfigService sysConfigService;

    static {
        OSSFactory.sysConfigService = (SysConfigService) SpringContextUtils.getBean("sysConfigService");
    }

    public static CloudStorageService build(){
        //获取云存储配置信息
        CloudStorageConfig config = sysConfigService.getConfigObject(Constant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);

        if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
            return new AliyunCloudStorageService(config);
        }
        return null;
    }
}
