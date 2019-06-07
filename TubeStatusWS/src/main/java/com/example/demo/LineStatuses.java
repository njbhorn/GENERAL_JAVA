package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LineStatuses {
	
	private String statusSeverityDescription ;

	public String getStatusSeverityDescription() {
		return statusSeverityDescription;
	}

	public void setStatusSeverityDescription(String statusSeverityDescription) {
		this.statusSeverityDescription = statusSeverityDescription;
	}

	@Override
	public String toString() {
		return "LineStatuses [statusSeverityDescription=" + statusSeverityDescription + "]";
	}
	
	

}
