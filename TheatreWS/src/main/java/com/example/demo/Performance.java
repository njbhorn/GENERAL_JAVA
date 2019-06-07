package com.example.demo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="performance")
public class Performance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int perfID;
	private LocalDateTime perfDateTime;
	private String showName;
	private int groupID;
	public int getPerfID() {
		return perfID;
	}
	
	public Performance () {
		
	}
	
	public void setPerfID(int perfID) {
		this.perfID = perfID;
	}
	public LocalDateTime getPerfDateTime() {
		return perfDateTime;
	}
	public void setPerfDateTime(LocalDateTime perfDateTime) {
		this.perfDateTime = perfDateTime;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public int getGroupID() {
		return groupID;
	}
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	
	

}
