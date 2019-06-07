package com.example.demo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="theatregroup")
public class TheatreGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int groupID;
	@Column(name="GroupName")
	private String groupName;
	@Column(name="Director")
	private int director;
	@Column(name="RegionID")
	private String regionID;
	@Column(name="DateStarted")
	private String dateStarted;
	@Column(name="AnnualRevenue")
	private double annualRevenue;
	@Column(name="TheatreName")
	private String theatreName;
	
	public TheatreGroup() {
		
	}

	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getDirector() {
		return director;
	}

	public void setDirector(int director) {
		this.director = director;
	}

	public String getRegionID() {
		return regionID;
	}

	public void setRegionID(String regionID) {
		this.regionID = regionID;
	}

	public String getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(String dateStarted) {
		this.dateStarted = dateStarted;
	}

	public double getAnnualRevenue() {
		return annualRevenue;
	}

	public void setAnnualRevenue(double annualRevenue) {
		this.annualRevenue = annualRevenue;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	@Override
	public String toString() {
		return "TheatreGroup [groupID=" + groupID + ", groupName=" + groupName + ", director=" + director
				+ ", regionID=" + regionID + ", dateStarted=" + dateStarted + ", annualRevenue=" + annualRevenue
				+ ", theatreName=" + theatreName + ", getGroupID()=" + getGroupID() + ", getGroupName()="
				+ getGroupName() + ", getDirector()=" + getDirector() + ", getRegionID()=" + getRegionID()
				+ ", getDateStarted()=" + getDateStarted() + ", getAnnualRevenue()=" + getAnnualRevenue()
				+ ", getTheatreName()=" + getTheatreName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
}
