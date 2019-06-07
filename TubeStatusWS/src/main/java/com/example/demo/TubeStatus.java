package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TubeStatus {

    private String id;
    private String name;
    private LineStatuses[] lineStatuses ;

    public TubeStatus() {
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LineStatuses[] getLineStatuses() {
		return lineStatuses;
	}

	public void setLineStatuses(LineStatuses[] lineStatuses) {
		this.lineStatuses = lineStatuses;
	}

	@Override
	public String toString() {
		return "TubeStatus [id=" + id + ", name=" + name + ", lineStatuses=" + lineStatuses + "]";
	}

    
}
