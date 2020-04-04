package com.aikiinc.coronavirus.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Optional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aikiinc.coronavirus.exception.CoronaVirusException;
import com.aikiinc.coronavirus.model.CoronaVirus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CoronaVirusUtil {
	private static Logger LOG = LoggerFactory.getLogger(CoronaVirusUtil.class);
	private static Map<String, List<CoronaVirus>> coronaVirusDataRegionsMap = new TreeMap<String, List<CoronaVirus>>();
	private static Map<String, List<CoronaVirus>> coronaVirusCountyBoroughMap = new TreeMap<String, List<CoronaVirus>>();
	private static String dateLoaded = "99/99/9999";
	private static BufferedReader br = null;

	public static Optional<Iterable<CSVRecord>> readData(URL dataUrl) throws CoronaVirusException {
		Optional<Iterable<CSVRecord>> records = Optional.empty();

		try {
			br = new BufferedReader(new InputStreamReader(dataUrl.openStream()));

			// Get the iterable records
			Iterable<CSVRecord> trecords = CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreEmptyLines().parse(br);
			records = Optional.of(trecords);
		} catch (Exception e) {
			LOG.warn("Data was NOT read from: " + dataUrl);

			throw new CoronaVirusException(e);
		}

		return records;
	}

	public static void closeBuffer() {
		try {
			if (br != null)
				br.close();
		} catch (IOException e) {
		}
	}

	/**
	 * Extract the coronavirus data:<br/>
	 * 1. Create list of CoronaVirusData - coronaVirusDataList<br/>
	 * 2. Create keys of retrieved regions - country
	 * 
	 * There was a change in the naming format of the data an more data was added.
	 * Now we try to read:<br/>
	 * The new data format first.<br/>
	 * Then fall back to the old.
	 * 
	 * @param records
	 */
	public static List<CoronaVirus> extractData(Optional<Iterable<CSVRecord>> records) {
		List<CoronaVirus> coronaVirusDataList = new ArrayList<CoronaVirus>();

		if (records.isPresent()) {
			int firstrec = 0;

			for (CSVRecord record : records.get()) {
				CoronaVirus data = new CoronaVirus();

				try {
					data.setFips(Integer.parseInt(record.get("FIPS")));
				} catch (Exception e) {
				}

				try {
					data.setCountyBorough(record.get("Admin2").trim());
				} catch (Exception e) {
				}

				try {
					data.setProvince(record.get("Province_State").trim());
				} catch (Exception e) {
					try {
						data.setProvince(record.get("Province/State").trim());
					} catch (Exception e2) {
						data.setProvince(",");
					}
				}

				try {
					data.setRegion(record.get("Country_Region").trim());
				} catch (Exception e) {
					try {
						data.setRegion(record.get("Country/Region").trim());
					} catch (Exception e2) {
						data.setRegion(",");
					}
				}

				try {
					data.setLastUpdate(record.get("Last_Update").trim());
				} catch (Exception e) {
					try {
						data.setLastUpdate(record.get("Last Update").trim());
					} catch (Exception e2) {
						data.setLastUpdate(",");
					}
				}

				try {
					data.setLatitude(record.get("Lat").trim());
				} catch (Exception e) {
					try {
						data.setLatitude(record.get("Latitude").trim());
					} catch (Exception e2) {
						data.setLatitude(",");
					}
				}

				try {
					data.setLongitude(record.get("Long_").trim());
				} catch (Exception e) {
					try {
						data.setLongitude(record.get("Longitude").trim());
					} catch (Exception e2) {
						data.setLongitude(",");
					}
				}

				try {
					data.setConfirmed(record.get("Confirmed").trim());
				} catch (Exception e) {
					data.setConfirmed(",");
				}

				try {
					data.setDeaths(record.get("Deaths").trim());
				} catch (Exception e) {
					data.setDeaths(",");
				}

				try {
					data.setRecovered(record.get("Recovered").trim());
				} catch (Exception e) {
					data.setRecovered(",");
				}

				try {
					data.setActive(record.get("Active").trim());
				} catch (Exception e) {
					data.setRecovered(",");
				}

				try {
					data.setCombinedKey(record.get("Combined_Key").trim());
				} catch (Exception e) {
					data.setCombinedKey(",");
				}

				// LOG.debug(j++ + ": " + data.toString());

				/**
				 * Create the coronaVirusList
				 */
				if (data.getRegion() != null && data.getRegion().length() > 1) {
					coronaVirusDataList.add(data);

					if (firstrec == 1) {
						Optional<String> sdate = getReportedDate(data.getLastUpdate());
						if (sdate.isPresent()) {
							dateLoaded = sdate.get();
						}
					}
					firstrec++;

					/**
					 * Create Maps For regions
					 */
					cacheCoronaVirusDataByRegion(data);

					/**
					 * Create Maps For county or borough
					 */
					cacheCoronaVirusDataByCountyBorough(data);
				}
			}
		}

		return coronaVirusDataList;
	}

	private static void cacheCoronaVirusDataByRegion(CoronaVirus data) {
		String region = data.getRegion();
		if (region != null && !region.isEmpty()) {
			List<CoronaVirus> tlist = coronaVirusDataRegionsMap.get(region);
			if (tlist == null) {
				// Create new list, add entry
				tlist = new ArrayList<CoronaVirus>();
				tlist.add(data);
			} else {
				// Update list, add entry
				tlist.add(data);
			}

			coronaVirusDataRegionsMap.put(region, tlist);
		}
	}

	private static void cacheCoronaVirusDataByCountyBorough(CoronaVirus data) {
		String region = data.getRegion();
		if (region != null && !region.isEmpty()) {
			String province = data.getProvince();
			if (province != null && !province.isEmpty()) {
				// For this country / city. Save it's borough
				String county = data.getCountyBorough();
				if (county != null && !county.isEmpty()) {
					String key = region + "-" + province;
					List<CoronaVirus> tlist = coronaVirusCountyBoroughMap.get(key);
					if (tlist == null) {
						// Create new list for borough
						tlist = new ArrayList<CoronaVirus>();
						tlist.add(data);
					} else {
						// Update the borough
						tlist.add(data);
					}

					coronaVirusCountyBoroughMap.put(key, tlist);
				}
			}
		}
	}

	private static Optional<String> getReportedDate(String reportedDate) {
		Optional<String> optdate = Optional.empty();

		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime ldate = LocalDateTime.parse(reportedDate, formatter);
			String sdate = ldate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

			optdate = Optional.ofNullable(sdate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return optdate;
	}

	public static Set<String> getRegionKeys() {
		return coronaVirusDataRegionsMap.keySet();
	}

	public static Map<String, List<CoronaVirus>> getCoronaVirusDataRegionsMap() {
		return coronaVirusDataRegionsMap;
	}

	public static Set<String> getCountyBoroughKeys() {
		return coronaVirusCountyBoroughMap.keySet();
	}

	public static Map<String, List<CoronaVirus>> getCoronaVirusCountyBoroughMap() {
		return coronaVirusCountyBoroughMap;
	}
	
	public static List<CoronaVirus> getCoronaVirusByRegion(String region) {
		return coronaVirusDataRegionsMap.get(region);
	}

	public static String getDateLoaded() {
		return dateLoaded;
	}

}