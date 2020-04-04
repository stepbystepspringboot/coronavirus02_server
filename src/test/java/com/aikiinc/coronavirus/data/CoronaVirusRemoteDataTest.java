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

public class CoronaVirusRemoteDataTest {
	private static Logger LOG = LoggerFactory.getLogger(CoronaVirusRemoteDataTest.class);
	private static CoronaVirusRemoteData coronaVirusRemoteData;

	@BeforeAll
	public static void setUp() {
		try {
			coronaVirusRemoteData = CoronaVirusRemoteData.getInstance();
			coronaVirusRemoteData.process();
		} catch (CoronaVirusException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void getCoronaVirusList() {
		List<CoronaVirus> coronaDataList = coronaVirusRemoteData.getCoronaVirusList();
		Assert.assertTrue(coronaDataList.size() > 0);
		coronaDataList.forEach(e -> LOG.debug(e.toString()));
	}

	@Test
	public void getDateLoaded() {
		String dateLoaded = coronaVirusRemoteData.getDateLoaded();
		Assert.assertNotNull(dateLoaded);
		LOG.debug("dateLoaded: " + dateLoaded);
	}

	@Test
	public void getRegionKeys() {
		Set<String> keys = coronaVirusRemoteData.getRegionKeys();
		Assert.assertTrue(keys.size() > 0);
		keys.forEach(e -> LOG.debug(e.toString()));
	}

	@Test
	public void getCoronaVirusRegionsMap() {
		Map<String, List<CoronaVirus>> map = CoronaVirusUtil.getCoronaVirusDataRegionsMap();
		Set<String> keys = map.keySet();
		Assert.assertTrue(keys.size() > 0);
		keys.forEach(e -> LOG.debug(e.toString()));
		keys.forEach(e -> LOG.debug(map.get(e).toString()));
	}

	@Test
	public void getCoronaVirusByRegion() {
		String region = "United Kingdom";
		region = "Australia";
		region = "US";
		List<CoronaVirus> coronaDataList = CoronaVirusUtil.getCoronaVirusByRegion(region);
		Assert.assertTrue(coronaDataList.size() > 0);
		coronaDataList.forEach(e -> LOG.debug(e.toString()));
	}

	@Test
	public void getCountyBoroughKeys() {
		Set<String> keys = coronaVirusRemoteData.getCountyBoroughKeys();
		Assert.assertTrue(keys.size() > 0);
		keys.forEach(e -> LOG.debug(e.toString()));

		// US-Alabama
		// US-New York
	}

	@Test
	public void getCoronaVirusCountyBoroughMap() {
		Map<String, List<CoronaVirus>> map = CoronaVirusUtil.getCoronaVirusCountyBoroughMap();
		Set<String> keys = map.keySet();
		Assert.assertTrue(keys.size() > 0);
		// keys.forEach(e -> LOG.debug(e.toString()));
		// keys.forEach(e -> LOG.debug(map.get(e).toString()));
		for (String key : map.keySet()) {
			//LOG.debug("Key: " + key);
			//LOG.debug("\t" + map.get(key));
			if (key.contains("New York" )) {
				LOG.debug("Key: " + key);
				LOG.debug("\t" + map.get(key));				
			}
		}
	}

}