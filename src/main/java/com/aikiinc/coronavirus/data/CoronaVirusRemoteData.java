package com.aikiinc.coronavirus.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aikiinc.coronavirus.exception.CoronaVirusException;
import com.aikiinc.coronavirus.utility.CoronaVirusUtil;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class CoronaVirusRemoteData extends CoronaVirusCommon implements CornaVirusData {
	private Logger log = LoggerFactory.getLogger(CoronaVirusRemoteData.class);
	public final static String SOURCE_URL_PREFIX = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/";
	private static String sourceUrlPrefix;
	private URL remoteUrl;

	private CoronaVirusRemoteData() {
	}

	private CoronaVirusRemoteData(String sourceUrlPrefix) throws CoronaVirusException {
		CoronaVirusRemoteData.sourceUrlPrefix = sourceUrlPrefix;
		log.debug(CoronaVirusRemoteData.sourceUrlPrefix);
	}

	/**
	 * Create a CoronaVirusLocalData instance and process loading the data
	 * 
	 * @return
	 * @throws CoronaVirusException
	 */
	public static final CoronaVirusRemoteData getInstance() throws CoronaVirusException {
		CoronaVirusRemoteData CoronaVirusRemoteData = new CoronaVirusRemoteData(sourceUrlPrefix);

		return CoronaVirusRemoteData;
	}

	public void process() throws CoronaVirusException {
		setRemoteConnection();
		setURL();
		readData();
		extractData();
		CoronaVirusUtil.closeBuffer();
	}

	void setURL() {
		super.coroSiteURL = remoteUrl;
	}

	void setRemoteConnection() throws CoronaVirusException {
		// String sdate =
		// LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
		/**
		 * Get prior date
		 */
		String sdate = LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
		log.debug("Load coronavirus data for date: " + sdate);

		String sourceUrl = SOURCE_URL_PREFIX + sdate + ".csv";
		try {
			this.remoteUrl = new URL(sourceUrl);

			remoteUrl.getContent();

			log.debug("\tLoading data from: " + remoteUrl);
		} catch (Exception e) {
			log.warn("\tCould not load data from: " + sourceUrl);
			log.warn("\tException: " + e.getMessage());
		}
	}

}
