package com.sqlm.pojo;

import java.util.Date;

/**
 * @decription TActivityhis
 * <p>发布活动历史记录</p>
 * @author Yampery
 * @date 2017/9/7 15:31
 */
public class TActivityhis {
    private Long activityId;

    private String activityName;

    private String publishUser;

    private String publishUnit;

    private Date publishTime;

    private Date updateTime;

    private Boolean pushLevel;

    private Boolean auditStatus;

    private Boolean activityStatus;

    private String activityInfo;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getPublishUser() {
        return publishUser;
    }

    public void setPublishUser(String publishUser) {
        this.publishUser = publishUser;
    }

    public String getPublishUnit() {
        return publishUnit;
    }

    public void setPublishUnit(String publishUnit) {
        this.publishUnit = publishUnit;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getPushLevel() {
        return pushLevel;
    }

    public void setPushLevel(Boolean pushLevel) {
        this.pushLevel = pushLevel;
    }

    public Boolean getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Boolean auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Boolean getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Boolean activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getActivityInfo() {
        return activityInfo;
    }

    public void setActivityInfo(String activityInfo) {
        this.activityInfo = activityInfo;
    }
}