package com.example.demo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
//@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class MixwayStationLightJson {

	@JsonProperty("ResultSet")
	ResultSet resultSet;

}

@Data
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
class ResultSet {
	@JsonProperty("apiVersion")
	String apiVersion;
	@JsonProperty("engineVersion")
	String engineVersion;
	List<Point> point;
}

@Data
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
class Point {
	Station station;
	Prefecture prefecture;
}

@Data
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
class Station {
	@JsonProperty("code")
	String code;
	String name;
	String type;
	String yomi;
}

@Data
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
class Prefecture {
	@JsonProperty("code")
	String code;
	String name;
}
