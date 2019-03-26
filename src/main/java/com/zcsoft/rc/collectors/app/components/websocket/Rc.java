package com.zcsoft.rc.collectors.app.components.websocket;

public class Rc {

    /**
     * 机车
     */
    public static final String TYPE_LOCOMOTIVE="00";
    /**
     * 列车
     */
    public static final String TYPE_TRAIN="01";
    /**
     * 施工人员
     */
    public static final String TYPE_BUILDER="02";
    /**
     * 安全防护员
     */
    public static final String TYPE_SAFETY_PROTECTOR="03";
    /**
     * 作业负责人
     */
    public static final String TYPE_LEADING_OFFICIAL="04";
    /**
     * 监理
     */
    public static final String TYPE_SUPERVISOR="05";
    /**
     * 其它人员
     */
    public static final String TYPE_OTHER="06";

    /**
     * id
     */
    private String id;
    /**
     * 类型
     */
    private String type;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 维度
     */
    private Double latitude;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rc{");
        sb.append("id='").append(id).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append('}');
        return sb.toString();
    }
}
