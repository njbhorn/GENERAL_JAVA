package enums;

public class EnumsTest2 {

	public static void main(String[] args) {
		System.out.println("Print out days of week...");

		DaysOfWeek2 day = DaysOfWeek2.MONDAY;

		System.out.println(day.getOrdinal());
		System.out.println(day.getShortDayName());

		for ( DaysOfWeek2 d : DaysOfWeek2.values()) {
			System.out.println(d.getOrdinal() + " " + d.getShortDayName());
		}
	}

	private static String testMethod(DaysOfWeek day) {
		String ret = null;
		switch (day) {
		case MONDAY:
			ret = "Mon";
			break;
		case TUESDAY:
			ret = "Tue";
			break;
		case WEDNESDAY:
			ret = "Wed";
			break;
		case THURSDAY:
			ret = "Thu";
			break;
		case FRIDAY:
			ret = "Fri";
			break;
		case SATURDAY:
			ret = "W/k";
			break;
		case SUNDAY:
			ret = "W/k";
			break;
		}
		return ret;
	}

}
