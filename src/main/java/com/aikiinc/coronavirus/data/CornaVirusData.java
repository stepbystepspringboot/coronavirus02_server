package com.aikiinc.coronavirus.data;

import com.aikiinc.coronavirus.exception.CoronaVirusException;
import com.aikiinc.coronavirus.service.CoronaVirusService;

public interface CornaVirusData extends CoronaVirusService {
	public void process() throws CoronaVirusException;
}