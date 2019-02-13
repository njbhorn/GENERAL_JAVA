package enums;

public class EnumsTest {

	public static void main(String[] args) {
		System.out.println("Print out days of week...");

		DaysOfWeek day = DaysOfWeek.SATURDAY;

		System.out.println(testMethod(day));

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
