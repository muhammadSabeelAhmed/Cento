package app.discoveritech.cento_centralizedcontrol.Model;

import android.widget.ScrollView;

public class Devices implements IDevices {
    private String name;
    private String lastUpdate;
    private String status;
    private String scheduledTime;
    private String location;
    private String device_id;
    private String conn;

    public Devices(String name, String lastUpdate, String status, String scheduledTime, String location) {
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.status = status;
        this.scheduledTime = scheduledTime;
        this.location = location;
    }

    public Devices(String name, String lastUpdate, String status, String scheduledTime, String location, String device_id) {
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.status = status;
        this.scheduledTime = scheduledTime;
        this.location = location;
        this.device_id = device_id;
    }

    public Devices(String name, String lastUpdate, String status, String scheduledTime, String location, String device_id, String conn) {
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.status = status;
        this.scheduledTime = scheduledTime;
        this.location = location;
        this.device_id = device_id;
        this.conn = conn;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getConn() {
        return conn;
    }

    public void setConn(String conn) {
        this.conn = conn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public String getScheduledTime() {
        return scheduledTime;
    }
}
