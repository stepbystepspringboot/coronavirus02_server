package com.aikiinc.coronavirus.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aikiinc.coronavirus.model.CoronaVirus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aikiinc.coronavirus.data.CornaVirusData;
import com.aikiinc.coronavirus.data.CoronaVirusLocalData;
import com.aikiinc.coronavirus.data.CoronaVirusRemoteData;
import com.aikiinc.coronavirus.exception.CoronaVirusException;

@Service
public class CoronaVirusProcessing implements CoronaVirusService {
	private Logger log = LoggerFactory.getLogger(CoronaVirusProcessing.class);
	private CornaVirusData cornaVirusData;

	public void process() {
		try {
			cornaVirusData = CoronaVirusRemoteData.getInstance();
			cornaVirusData.process();
			log.debug("Loaded " + cornaVirusData.getCoronaVirusList().size() + " CoronaVirus remote records.");
		} catch (CoronaVirusException e) {
			log.warn("Error loading remote data: " + e.getMessage());
			try {
				cornaVirusData = CoronaVirusLocalData.getInstance();
				cornaVirusData.process();
				log.debug("Loaded " + cornaVirusData.getCoronaVirusList().size() + " CoronaVirus local records.");
			} catch (CoronaVirusException e1) {
				log.warn("Error loading local data: " + e.getMessage());
			}
		}
	}

	@Override
	public String getDateLoaded() {
		return cornaVirusData.getDateLoaded();
	}

	@Override
	public Map<String, List<CoronaVirus>> getCoronaVirusRegionsMap() {
		return cornaVirusData.getCoronaVirusRegionsMap();
	}

	@Override
	public Set<String> getRegionKeys() {
		return cornaVirusData.getRegionKeys();
	}

	@Override
	public List<CoronaVirus> getCoronaVirusList() {
		return cornaVirusData.getCoronaVirusList();
	}

	@Override
	public List<CoronaVirus> getCoronaVirusByRegion(String region) {
		return cornaVirusData.getCoronaVirusByRegion(region);
	}

	@Override
	public Set<String> getCountyBoroughKeys() {
		return cornaVirusData.getCountyBoroughKeys();
	}

	@Override
	public Map<String, List<CoronaVirus>> getCoronaVirusCountyBoroughMap() {
		return cornaVirusData.getCoronaVirusCountyBoroughMap();
	}

}