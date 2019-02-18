package com.crx.khatib.CodingExercice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crx.khatib.service.WaterVolumeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodingExerciceApplicationTests {
	
	@Autowired
	private WaterVolumeService waterVolumeService;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void calculateWaterVolumeTest() {
		int[] array = {3,2,4,1,2};
		assertEquals(2, waterVolumeService.calculateWaterVolume(array));
	}

}
