package com.crx.khatib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crx.khatib.service.WaterVolumeService;

@RestController
public class WaterVolumeController {
	
	@Autowired
	private WaterVolumeService waterVolumeService;
	
	@GetMapping("/calculateWaterVolume")
	public int calculateWaterVolume(int[] array) {
		return waterVolumeService.calculateWaterVolume(array);
	}

}
