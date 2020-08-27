package com.honeywell.iot.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeywell.iot.model.TelemetryInfo;

public interface TelemetryDataRepo extends JpaRepository<TelemetryInfo, Integer> {

}
