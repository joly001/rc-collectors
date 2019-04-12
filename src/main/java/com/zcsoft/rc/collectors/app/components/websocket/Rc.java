package com.zcsoft.rc.collectors.app.components.websocket;

public class Rc {

    /**
     * id
     */
    private String id;
    /**
     * 类型
     */
    private String type;
    /**
     * 手环编码
     */
    private String wristStrapCode;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 维度
     */
    private Double latitude;
    /**
     * 警告状态
     */
    private Boolean warningStatus;
    /**
     * 警告信息
     */
    private String warning;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWristStrapCode() {
        return wristStrapCode;
    }

    public void setWristStrapCode(String wristStrapCode) {
        this.wristStrapCode = wristStrapCode;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Boolean getWarningStatus() {
        return warningStatus;
    }

    public void setWarningStatus(Boolean warningStatus) {
        this.warningStatus = warningStatus;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rc{");
        sb.append("id='").append(id).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", wristStrapCode='").append(wristStrapCode).append('\'');
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", warningStatus=").append(warningStatus);
        sb.append(", warning='").append(warning).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
