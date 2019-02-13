package enums;

public enum DaysOfWeek2 {
	MONDAY(2,"Mon"), TUESDAY(3, "Tue"), WEDNESDAY(4, "Wed"), THURSDAY(5, "Thu"), FRIDAY(6, "Fri"), SATURDAY(7, "W/k"), SUNDAY(1, "W/k") ;

	private int ordinal ;
	private String shortDayName ;

	private DaysOfWeek2 ( int ordinal, String shortDayName ) {
		this.ordinal = ordinal ;
		this.shortDayName = shortDayName ;
	}

	public int getOrdinal() {
		return ordinal;
	}

	public String getShortDayName() {
		return shortDayName;
	}


}
