package com.zcsoft.rc.collectors.app.components.websocket.geojson;

public class GeoJson {

    private String type;
    private Properties properties;
    private Geometry geometry;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GeoJson{");
        sb.append("type='").append(type).append('\'');
        sb.append(", properties=").append(properties);
        sb.append(", geometry=").append(geometry);
        sb.append('}');
        return sb.toString();
    }
}
