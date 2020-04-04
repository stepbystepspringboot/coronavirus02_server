package com.aikiinc.coronavirus.data;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aikiinc.coronavirus.exception.CoronaVirusException;
import com.aikiinc.coronavirus.model.CoronaVirus;
import com.aikiinc.coronavirus.utility.CoronaVirusUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CoronaVirusLocalDataTest {
	private static Logger LOG = LoggerFactory.getLogger(CoronaVirusLocalDataTest.class);
	private static CoronaVirusLocalData coronaVirusLocalData;

	@BeforeAll
	public static void setUp() {
		try {
			coronaVirusLocalData = CoronaVirusLocalData.getInstance();
			coronaVirusLocalData.process();
		} catch (CoronaVirusException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void getCoronaVirusList() {
		List<CoronaVirus> coronaDataList = coronaVirusLocalData.getCoronaVirusList();
		Assert.assertTrue(coronaDataList.size() > 0);
		coronaDataList.forEach(e -> LOG.debug(e.toString()));
	}

	@Test
	public void getDateLoaded() {
		String dateLoaded = coronaVirusLocalData.getDateLoaded();
		Assert.assertNotNull(dateLoaded);
		LOG.debug("dateLoaded: " + dateLoaded);
	}

	@Test
	public void getRegionKeys() {
		Set<String> keys = coronaVirusLocalData.getRegionKeys();
		Assert.assertTrue(keys.size() > 0);
		keys.forEach(e -> LOG.debug(e.toString()));
	}

	@Test
	public void getCoronaVirusRegionsMap() {
		Map<String, List<CoronaVirus>> map = coronaVirusLocalData.getCoronaVirusRegionsMap();
		Set<String> keys = map.keySet();
		Assert.assertTrue(keys.size() > 0);
		keys.forEach(e -> LOG.debug(e.toString()));
		keys.forEach(e -> LOG.debug(map.get(e).toString()));
	}

	@Test
	public void getCoronaVirusByRegion() {
		String region = "UK";
		List<CoronaVirus> coronaDataList = coronaVirusLocalData.getCoronaVirusByRegion(region);
		Assert.assertTrue(coronaDataList.size() > 0);
		coronaDataList.forEach(e -> LOG.debug(e.toString()));
	}


	@Test
	public void getCountyBoroughKeys() {
		Set<String> keys = coronaVirusLocalData.getCountyBoroughKeys();
		Assert.assertTrue(keys.size() > 0);
		keys.forEach(e -> LOG.debug(e.toString()));
	}

	@Test
	public void getCoronaVirusCountyBoroughMap() {
		Map<String, List<CoronaVirus>> map = coronaVirusLocalData.getCoronaVirusCountyBoroughMap();
		Set<String> keys = map.keySet();
		Assert.assertTrue(keys.size() > 0);
		// keys.forEach(e -> LOG.debug(e.toString()));
		// keys.forEach(e -> LOG.debug(map.get(e).toString()));
		for (String key : map.keySet()) {
			//LOG.debug("Key: " + key);
			//LOG.debug("\t" + map.get(key));
			String cnty = "New York";
			cnty = "Iowa";
			if (key.contains(cnty)) {
				LOG.debug("Key: " + key);
				LOG.debug("\t" + map.get(key));				
			}
		}
	}

}