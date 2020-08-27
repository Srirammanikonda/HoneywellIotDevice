package com.honeywell.iot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honeywell.iot.interfaces.TelemetryDataRepo;
import com.honeywell.iot.interfaces.TelemetryService;
import com.honeywell.iot.model.TelemetryInfo;

@RestController
@RequestMapping("/iot")
public class HoneywellIotController {

	@Autowired
	TelemetryDataRepo telemetryDataRepo;

	@Autowired
	TelemetryService telemetryService;

	@GetMapping(path = "/readings", produces = { "application/json", "application/xml" })
	public List<TelemetryInfo> getAllReadings() {

		return telemetryDataRepo.findAll();
	}

	@GetMapping("/device/{deviceId}")
	public ResponseEntity<List<TelemetryInfo>> getReadingbyId(@PathVariable("deviceId") int deviceId) {
		List<TelemetryInfo> telemetryData = telemetryService.getReadingByDeviceId(deviceId);
		return ResponseEntity.status(HttpStatus.OK).body(telemetryData);
	}

	@PostMapping(path = "/device/{deviceId}/data", consumes = { "application/json" })
	public ResponseEntity<String> addReading(@RequestBody TelemetryInfo telemetryInfo) {
		String response = telemetryService.addReading(telemetryInfo);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping("/deleteReading/{rid}")
	public ResponseEntity<String> deleteReading(@PathVariable int rid) {
		TelemetryInfo a = telemetryDataRepo.getOne(rid);

		telemetryDataRepo.delete(a);

		return ResponseEntity.status(HttpStatus.OK).body("Record deleted Successfully");
	}

	@PutMapping(path = "/updateReading")
	public ResponseEntity<String> updateReading(@RequestBody TelemetryInfo TelemetryInfo) {
		telemetryDataRepo.save(TelemetryInfo);
		return ResponseEntity.status(HttpStatus.OK).body("Reading updated Successfully");
	}

}
