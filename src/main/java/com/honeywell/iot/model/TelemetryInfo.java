package com.honeywell.iot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class TelemetryInfo {
	
	@Id
	@GeneratedValue
	private int rid;
	
	private int deviceId;
	
	@Column(nullable=false, unique=true)
	private float reading;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public float getReading() {
		return reading;
	}
	
	public void setReading(float reading) {
		this.reading = reading;
	}
	@Override
	public String toString() {
		return "TelemetryInfo [rid=" + rid + ", deviceId=" + deviceId + ", reading=" + reading + ", getRid()="
				+ getRid() + ", getDeviceId()=" + getDeviceId() + ", getReading()=" + getReading() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
