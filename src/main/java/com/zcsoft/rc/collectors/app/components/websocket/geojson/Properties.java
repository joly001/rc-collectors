package com.zcsoft.rc.collectors.app.components.websocket.geojson;

public class Properties {

    private String id;
    private Double x;
    private Double y;
    private String type;
    private String wristStrapCode;
    private String warningStatus;
    private String warning;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
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

    public String getWarningStatus() {
        return warningStatus;
    }

    public void setWarningStatus(String warningStatus) {
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
        final StringBuilder sb = new StringBuilder("Properties{");
        sb.append("id='").append(id).append('\'');
        sb.append(", x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", type='").append(type).append('\'');
        sb.append(", wristStrapCode='").append(wristStrapCode).append('\'');
        sb.append(", warningStatus='").append(warningStatus).append('\'');
        sb.append(", warning='").append(warning).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
