package com.aikiinc.coronavirus;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aikiinc.coronavirus.model.CoronaVirus;
import com.aikiinc.coronavirus.service.CoronaVirusProcessing;
import com.aikiinc.coronavirus.service.CoronaVirusService;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "https://pure-shore-41784.herokuapp.com", maxAge = 3600)
//@CrossOrigin(origins = "http://localhost:9000", maxAge = 3600)
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/virus/corona")
public class CornaVirusController implements CoronaVirusService {
	private Logger log = LoggerFactory.getLogger(CornaVirusController.class);

	@Autowired
	private CoronaVirusProcessing coronaVirusProcessing;

	public CornaVirusController(CoronaVirusProcessing process) {
		this.coronaVirusProcessing = process;

		if (coronaVirusProcessing != null) {
			log.info("Calling data processing");
			coronaVirusProcessing.process();
		}
	}

	@GetMapping(value = "/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "Hello message");
		mv.setViewName("index.html");

		return mv;
	}

	@GetMapping(value = "/dateLoaded")
	public @ResponseBody String getDateLoaded() {
		return coronaVirusProcessing.getDateLoaded();
	}

	@GetMapping(value = "/regionsMap")
	public Map<String, List<CoronaVirus>> getCoronaVirusRegionsMap() {
		return coronaVirusProcessing.getCoronaVirusRegionsMap();
	}

	@GetMapping(value = "/regions")
	public Set<String> getRegionKeys() {
		return coronaVirusProcessing.getRegionKeys();
	}

	@GetMapping(value = "/list")
	public List<CoronaVirus> getCoronaVirusList() {
		log.info("List all");
		
		return coronaVirusProcessing.getCoronaVirusList();
	}

	@GetMapping(value = "/region")
	public List<CoronaVirus> getCoronaVirusByRegion(@RequestParam("region") String region) {
		return coronaVirusProcessing.getCoronaVirusByRegion(region);
	}

	@GetMapping(value = "/countyKeys")
	public Set<String> getCountyBoroughKeys() {
		return coronaVirusProcessing.getCountyBoroughKeys();
	}

	@GetMapping(value = "/countyMap")
	public Map<String, List<CoronaVirus>> getCoronaVirusCountyBoroughMap() {
		return coronaVirusProcessing.getCoronaVirusCountyBoroughMap();
	}

}
