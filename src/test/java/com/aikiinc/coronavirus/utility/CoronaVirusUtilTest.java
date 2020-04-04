package com.aikiinc.coronavirus.utility;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aikiinc.coronavirus.exception.CoronaVirusException;
import com.aikiinc.coronavirus.model.CoronaVirus;

class CoronaVirusUtilTest {
	private static Logger LOG = LoggerFactory.getLogger(CoronaVirusUtilTest.class);
	private static URL dataUrl;

	@BeforeAll
	static void setUp() {
		String CORONAVIRUS_DATA = "coronavirus.data";
		dataUrl = CoronaVirusUtilTest.class.getClassLoader().getResource(CORONAVIRUS_DATA);
	}

	@Test
	void readData() {
		try {
			Optional<Iterable<CSVRecord>> records = CoronaVirusUtil.readData(dataUrl);
			if (records.isPresent()) {
				Assert.assertTrue(records.get().iterator().hasNext());

				try {
					records.get().forEach(e -> System.out.println(e));
				} catch (Exception e) {
				}
			} else
				Assert.fail("No CSVRecord was read");

		} catch (CoronaVirusException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	void extractData() {
		try {
			List<CoronaVirus> list = getData();
			// list.forEach(e -> System.out.println(e));
		} catch (Exception e) {
		}
	}

	private List<CoronaVirus> getData() {
		List<CoronaVirus> list = new ArrayList<CoronaVirus>();
		try {
			Optional<Iterable<CSVRecord>> records = CoronaVirusUtil.readData(dataUrl);
			if (records.isPresent()) {
				list = CoronaVirusUtil.extractData(records);
			} else
				Assert.fail("No CSVRecord was read");
		} catch (CoronaVirusException e) {
			Assert.fail(e.getMessage());
		}

		return list;
	}

	@Test
	public void getDateLoaded() {
		try {
			getData();

			
			String dateLoaded = CoronaVirusUtil.getDateLoaded();
			Assert.assertNotNull(dateLoaded);
			LOG.debug("dateLoaded: " + dateLoaded);
		} catch (Exception e) {
		}
	}

	@Test
	void getRegionKeys() {
		try {
			getData();
			Set<String> keys = CoronaVirusUtil.getRegionKeys();
			Assert.assertTrue(keys.size() > 0);
			// keys.forEach(e -> System.out.println(e));
		} catch (Exception e) {
		}
	}

	@Test
	public void getCoronaVirusRegionsMap() {
		try {
			getData();

			Map<String, List<CoronaVirus>> map = CoronaVirusUtil.getCoronaVirusDataRegionsMap();
			Set<String> keys = map.keySet();
			Assert.assertTrue(keys.size() > 0);
//			keys.forEach(e -> LOG.debug(e.toString()));
//			keys.forEach(e -> LOG.debug(map.get(e).toString()));
		} catch (Exception e) {
		}
	}

	@Test
	public void getCoronaVirusByRegion() {
		try {
			getData();

			String region = "United Kingdom";
			region = "Australia";
			region = "US";
			List<CoronaVirus> coronaDataList = CoronaVirusUtil.getCoronaVirusByRegion(region);
			Assert.assertTrue(coronaDataList.size() > 0);
			coronaDataList.forEach(e -> LOG.debug(e.toString()));
		} catch (Exception e) {
		}
	}

	@Test
	public void getCountyBoroughKeys() {
		try {
			getData();

			Set<String> keys = CoronaVirusUtil.getCountyBoroughKeys();
			Assert.assertTrue(keys.size() > 0);
			keys.forEach(e -> LOG.debug(e.toString()));
		} catch (Exception e) {
		}
	}

	@Test
	public void getCoronaVirusCountyBoroughMap() {
		try {
			getData();

			Map<String, List<CoronaVirus>> map = CoronaVirusUtil.getCoronaVirusCountyBoroughMap();
			Set<String> keys = map.keySet();
			Assert.assertTrue(keys.size() > 0);
			// keys.forEach(e -> LOG.debug(e.toString()));
			// keys.forEach(e -> LOG.debug(map.get(e).toString()));
			for (String key : map.keySet()) {
				//LOG.debug("Key: " + key);
				// LOG.debug("\t" + map.get(key));

				String cnty = "New York";
				cnty = "Iowa";
				if (key.contains(cnty)) {
					LOG.debug("Key: " + key);
					LOG.debug("\t" + map.get(key));
				}
			}
		} catch (Exception e) {
		}
	}

}