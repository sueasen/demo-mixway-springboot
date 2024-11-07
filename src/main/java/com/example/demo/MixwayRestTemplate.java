package com.example.demo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class MixwayRestTemplate {

	private RestTemplate restTemplate = new RestTemplate();

	@Value("${mixway.api.key}")
	private String key;

	public <T> T searchStation(String name, Class<T> responseType) {
		URI uri = UriComponentsBuilder.fromUriString("https://mixway.ekispert.jp")
				.path("/v1/json/station/light")
				.queryParam("key", key)
				.queryParam("type", "train")
				.queryParam("name", name)
				.build().encode().toUri();

		System.out.println(uri);

		return restTemplate.getForObject(uri, responseType);
	}

	public <T> T searchCourse(String from, String to, Class<T> responseType) {
		return searchCourse(List.of(from, to), responseType);
	}

	public <T> T searchCourse(List<String> viaList, Class<T> responseType) {
		URI uri = UriComponentsBuilder.fromUriString("https://mixway.ekispert.jp")
				.path("/v1/json/search/course/extreme")
				.queryParam("key", key)
				.queryParam("viaList", String.join(":", viaList))
				.build().encode().toUri();

		System.out.println(uri);

		return restTemplate.getForObject(uri, responseType);
	}
}
