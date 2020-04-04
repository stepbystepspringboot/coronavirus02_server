package com.aikiinc.coronavirus.data;

import java.net.URL;

import com.aikiinc.coronavirus.exception.CoronaVirusException;
import com.aikiinc.coronavirus.utility.CoronaVirusUtil;

public class CoronaVirusLocalData extends CoronaVirusCommon implements CornaVirusData {
	private static final String CORONAVIRUS_DATA = "coronavirus.data";
	private URL localUrl = CoronaVirusLocalData.class.getClassLoader().getResource(CORONAVIRUS_DATA);

	private CoronaVirusLocalData() {
	}

	/**
	 * Create a CoronaVirusLocalData instance and process loading the data
	 * 
	 * @return
	 * @throws CoronaVirusException
	 */
	public static final CoronaVirusLocalData getInstance() throws CoronaVirusException {
		CoronaVirusLocalData coronaVirusLocalData = new CoronaVirusLocalData();

		return coronaVirusLocalData;
	}

	public void process() throws CoronaVirusException {
		setURL();
		readData();
		extractData();
		CoronaVirusUtil.closeBuffer();
	}

	void setURL() {
		super.coroSiteURL = localUrl;
	}

}