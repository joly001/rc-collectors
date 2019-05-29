package com.zcsoft.rc.collectors.app.components.websocket.geojson;

import java.util.List;

public class Geometry {

    private String type;
    private List<Double> coordinates;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Geometry{");
        sb.append("type='").append(type).append('\'');
        sb.append(", coordinates=").append(coordinates);
        sb.append('}');
        return sb.toString();
    }
}
