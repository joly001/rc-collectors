package com.zcsoft.rc.collectors.zc.model.entity;

import com.zcsoft.rc.collectors.app.components.websocket.Rc;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class Zc {

    /**
     * id
     */
    @NotEmpty
    private String id;
    /**
     * 经度
     */
    @NotNull
    private Double longitude;
    /**
     * 维度
     */
    @NotNull
    private Double latitude;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Rc convertToRc() {
        Rc rc = new Rc();
        rc.setId(getId());
        rc.setLongitude(getLongitude());
        rc.setLatitude(getLatitude());

        return rc;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Zc{");
        sb.append("id='").append(id).append('\'');
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append('}');
        return sb.toString();
    }
}
