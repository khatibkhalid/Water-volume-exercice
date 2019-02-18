package com.crx.khatib.service.impl;

import org.springframework.stereotype.Service;

import com.crx.khatib.service.WaterVolumeService;

@Service
public class WaterVolumeServiceImpl implements WaterVolumeService {

	@Override
	public int calculateWaterVolume(int[] array) {
		int n = array.length;

		int tallestBarToLeftOfIndex[] = new int[n]; 
	
		int tallestBarToRightOfIndex[] = new int[n]; 
	
		int volume = 0; 

		// Get the tallest bar to the left of each bar
		tallestBarToLeftOfIndex[0] = array[0]; 
		for (int i = 1; i < n; i++) 
		tallestBarToLeftOfIndex[i] = Math.max(tallestBarToLeftOfIndex[i-1], array[i]); 
	
		// Get the tallest bar to the right of each bar
		tallestBarToRightOfIndex[n-1] = array[n-1]; 
		for (int i = n-2; i >= 0; i--) 
		tallestBarToRightOfIndex[i] = Math.max(tallestBarToRightOfIndex[i+1], array[i]); 
	
		
		for (int i = 0; i < n; i++) 
		volume += Math.min(tallestBarToLeftOfIndex[i],tallestBarToRightOfIndex[i]) - array[i]; 
	
		return volume; 
	}

}
