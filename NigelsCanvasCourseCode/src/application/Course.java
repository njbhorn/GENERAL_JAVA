package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Course {
	
	private StringProperty courseNo;
	private StringProperty courseCode;
	private StringProperty courseTitle;
	private StringProperty courseDesc;
	
	public Course() {
		super();
	}
	
	public Course(String... info) {
		for ( int i = 0 ; i < 4 ; i++ ) {
			switch (i) {
			case 0 :
//				Integer no = Integer.parseInt(info[0]);
				this.courseNo = new SimpleStringProperty(info[0]) ;
				break ;
			case 1 :
				this.courseCode = new SimpleStringProperty(info[1]);
				break ;
			case 2 :
				this.courseTitle = new SimpleStringProperty(info[2]);
				break ;
			case 3 :
				if (info.length == 3) {
					this.courseDesc = new SimpleStringProperty("To Do...");
				} else {
					this.courseDesc = new SimpleStringProperty(info[3]);
				}
				break ;
			}
		}
//		
	}

	public String getCourseNo() {
		return courseNo.get();
	}
	public void setCourseNo(String courseNo) {
		this.courseNo.set(courseNo);
	}
	public String getCourseCode() {
		return courseCode.get();
	}
	public void setCourseCode(String courseCode) {
		this.courseCode.set(courseCode);
	}
	public String getCourseTitle() {
		return courseTitle.get();
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle.set(courseTitle);
	}
	public String getCourseDesc() {
		return courseDesc.get();
	}
	public void setCourseDesc(String courseDesc) {
		this.courseDesc.set(courseDesc);
	}
	
	public StringProperty courseNo() {
		return courseNo ;
	}
	
	public StringProperty courseCode() {
		return courseCode ;
	}
	
	public StringProperty courseTitle() {
		return courseTitle ;
	}
	
	public StringProperty courseDesc() {
		return courseDesc ;
	}
	
	@Override
	public String toString() {
		return "Course [courseNo=" + courseNo + ", courseCode=" + courseCode + ", courseTitle=" + courseTitle
				+ ", courseDesc=" + courseDesc + "]";
	}

	
}
