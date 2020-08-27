package com.honeywell.iot.interfaces;

import java.util.List;

import com.honeywell.iot.model.TelemetryInfo;

public interface TelemetryService {

	String addReading(TelemetryInfo telemetryInfo);
	List<TelemetryInfo> getReadingByDeviceId(int deviceId);
}
