package com.honeywell.iot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeywell.iot.interfaces.TelemetryDataRepo;
import com.honeywell.iot.interfaces.TelemetryService;
import com.honeywell.iot.model.TelemetryInfo;

@Service
public class TelemetryServiceImpl implements TelemetryService{
	
	@Autowired
	TelemetryDataRepo telemetryDataRepo;

	@Override
	public String addReading(TelemetryInfo telemetryInfo) {
		try {
			telemetryDataRepo.save(telemetryInfo);
		}
		catch(Exception ex) {
			return "Something went wrong. Please check";
		}
		return "Reading Inserted Successfully";
	}

	@Override
	public List<TelemetryInfo> getReadingByDeviceId(int deviceId) {
		
		return telemetryDataRepo.findAll();
	}
	
}