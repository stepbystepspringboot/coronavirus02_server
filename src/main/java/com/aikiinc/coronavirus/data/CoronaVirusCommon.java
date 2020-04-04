package com.aikiinc.coronavirus.data;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aikiinc.coronavirus.exception.CoronaVirusException;
import com.aikiinc.coronavirus.model.CoronaVirus;
import com.aikiinc.coronavirus.service.CoronaVirusService;
import com.aikiinc.coronavirus.utility.CoronaVirusUtil;

public abstract class CoronaVirusCommon implements CoronaVirusService {
	private Logger log = LoggerFactory.getLogger(CoronaVirusCommon.class);
	private Optional<Iterable<CSVRecord>> csvRecords = Optional.empty();
	List<CoronaVirus> coronaVirusList;
	URL coroSiteURL;

	abstract void setURL();

	void readData() throws CoronaVirusException {
		log.info("Read data from: " + coroSiteURL);
		csvRecords = CoronaVirusUtil.readData(coroSiteURL);
	}

	void extractData() {
		coronaVirusList = CoronaVirusUtil.extractData(csvRecords);
	}

	@Override
	public List<CoronaVirus> getCoronaVirusList() {
		return coronaVirusList;
	}

	@Override
	public String getDateLoaded() {
		return CoronaVirusUtil.getDateLoaded();
	}

	@Override
	public Map<String, List<CoronaVirus>> getCoronaVirusRegionsMap() {
		return CoronaVirusUtil.getCoronaVirusDataRegionsMap();
	}

	@Override
	public Set<String> getRegionKeys() {
		return CoronaVirusUtil.getRegionKeys();
	}

	@Override
	public List<CoronaVirus> getCoronaVirusByRegion(String region) {
		return CoronaVirusUtil.getCoronaVirusByRegion(region);
	}

	@Override
	public Set<String> getCountyBoroughKeys() {
		return CoronaVirusUtil.getCountyBoroughKeys();
	}

	@Override
	public Map<String, List<CoronaVirus>> getCoronaVirusCountyBoroughMap() {
		return CoronaVirusUtil.getCoronaVirusCountyBoroughMap();
	}

}
