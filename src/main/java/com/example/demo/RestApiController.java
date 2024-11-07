package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

	@Autowired
	MixwayRestTemplate mixwayRestTemplate;

	@GetMapping("/rest/string")
	public String restString(@RequestParam(defaultValue = "東京") String name) {

		String json = mixwayRestTemplate.searchStation(name, String.class);
		return json;
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/rest/map")
	public Map<String, Object> restMap(@RequestParam(defaultValue = "東京") String name) {

		Map<String, Object> json = mixwayRestTemplate.searchStation(name, Map.class);
		return json;
	}

	@GetMapping("/rest/object")
	public MixwayStationLightJson restaObject(@RequestParam(defaultValue = "東京") String name) {

		MixwayStationLightJson json = mixwayRestTemplate.searchStation(name, MixwayStationLightJson.class);
		return json;
	}

	@GetMapping("/rest/course/string")
	public String restCourseaObject(@RequestParam(defaultValue = "東京") String from,
			@RequestParam(defaultValue = "千葉") String to) {

		MixwayStationLightJson fromStation = mixwayRestTemplate.searchStation(from, MixwayStationLightJson.class);
		MixwayStationLightJson toStation = mixwayRestTemplate.searchStation(to, MixwayStationLightJson.class);

		String json = mixwayRestTemplate.searchCourse(
				fromStation.getResultSet().getPoint().get(0).getStation().getCode(),
				toStation.getResultSet().getPoint().get(0).getStation().getCode(),
				String.class);

		return json;
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/rest/course/map")
	public Map<String, Object> restCourseaMap(@RequestParam(defaultValue = "東京") String from,
			@RequestParam(defaultValue = "千葉") String to) {

		MixwayStationLightJson fromStation = mixwayRestTemplate.searchStation(from, MixwayStationLightJson.class);
		MixwayStationLightJson toStation = mixwayRestTemplate.searchStation(to, MixwayStationLightJson.class);

		Map<String, Object> json = mixwayRestTemplate.searchCourse(
				fromStation.getResultSet().getPoint().get(0).getStation().getCode(),
				toStation.getResultSet().getPoint().get(0).getStation().getCode(),
				Map.class);

		return json;
	}

}
