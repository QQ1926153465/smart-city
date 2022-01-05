package com.briup.smartcity.bean;

public class BaseConfig {
    private Integer configId;

    private String configName;

    private String configInfo;

    private String configIcon;

    private Integer configStatus;

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigInfo() {
        return configInfo;
    }

    public void setConfigInfo(String configInfo) {
        this.configInfo = configInfo;
    }

    public String getConfigIcon() {
        return configIcon;
    }

    public void setConfigIcon(String configIcon) {
        this.configIcon = configIcon;
    }

    public Integer getConfigStatus() {
        return configStatus;
    }

    public void setConfigStatus(Integer configStatus) {
        this.configStatus = configStatus;
    }
}