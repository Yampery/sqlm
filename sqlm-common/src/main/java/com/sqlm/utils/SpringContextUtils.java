package com.sqlm.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

/**
 * @decription SpringContextUtils
 * <p>spring上下文工具</p>
 * @author Yampery
 * @date 2017/9/13 16:50
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {

    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return applicationContext.getBean(name, requiredType);
    }

    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    public static boolean isSingleton(String name) {
        return applicationContext.isSingleton(name);
    }

    public static Class<? extends Object> getType(String name) {
        return applicationContext.getType(name);
    }

    /**
     * 获取项目绝对路径
     * @return
     */
    public static String getRealPath() {
        return ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
    }

    /**
     * 获取项目名称
     * @return
     */
    public static String getProjectName() {
        String realPath = getRealPath();
        String [] strs = null;
        if (realPath.contains("/"))
            strs = realPath.split("/");
        else // windows下目录为'\'
            strs = realPath.split("\\\\");
        return strs[strs.length - 1];
    }
}
