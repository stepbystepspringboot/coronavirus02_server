package com.aikiinc.coronavirus.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aikiinc.coronavirus.model.CoronaVirus;

public interface CoronaVirusService {
	public String getDateLoaded();

	public Map<String, List<CoronaVirus>> getCoronaVirusRegionsMap();

	public Set<String> getRegionKeys();
	
	public Set<String> getCountyBoroughKeys();

	public Map<String, List<CoronaVirus>> getCoronaVirusCountyBoroughMap();

	public List<CoronaVirus> getCoronaVirusList();

	public List<CoronaVirus> getCoronaVirusByRegion(String region);
}