package strings;

import java.time.Duration;
import java.time.Instant;

public class DemoStringBuilder {

	public static void main(String[] args) {

//		demoStringIssues() ;
//		demoStringIssues2() ;
//		demoStringBuilder();
		demoStringBuilder2();
//		demoStringBuilder3();

	}

	private static void demoStringBuilder3() {
		StringBuilder sb = new StringBuilder("The") ;
		sb.append("Day");
		sb.append("is");
		sb.append("long");
//		displayStringBuilder(sb) ;
		sb.insert(3, " ") ;
//		displayStringBuilder(sb) ;
		sb.insert(7, " ") ;
//		displayStringBuilder(sb) ;
		sb.insert(10, " ") ;
		displayStringBuilder(sb) ;
//		displayString(sb.toString());
//		displayString(sb.substring(5));
//		displayString(sb.toString());
//		displayString(sb.substring(8,10));
		sb.reverse() ;
		displayStringBuilder(sb);
	}

	private static void displayString(String value) {
		System.out.println("0_________1_________2_________3");
		System.out.println("0123456789012345678901234567890");
		System.out.println(value + " -> " + value.length());
	}

	private static void displayStringBuilder(StringBuilder sb) {
		System.out.println("0_________1_________2_________3");
		System.out.println("0123456789012345678901234567890");
		System.out.println(sb + " -> " + sb.length());

	}

	private static void demoStringBuilder2() {
		Instant start ;
		Instant end ;
		Duration elapsed ;

		// test String
		start = Instant.now();
		String s = null ;
		for ( int i = 0 ; i < 100000 ; i++ ) {
			s += "x" ;
		}
		end = Instant.now();
		elapsed = Duration.between(start, end);
		System.out.println(s.length() + " long String took " + elapsed.toMillis());

		// test StringBuilder
		start = Instant.now();
		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < 100000 ; i++ ) {
			sb.append("x");
		}
		end = Instant.now();
		elapsed = Duration.between(start, end);
		System.out.println(sb.length() + " long StringBuilder took " + elapsed.toMillis());
	}

	private static void demoStringBuilder() {
		StringBuilder sb = new StringBuilder("abc") ;
		System.out.println(sb);
		sb.append("d");
		System.out.println(sb);

	}

	private static void demoStringIssues() {

		String s1 = "Fred" ;
		String s2 = "Fred" ;
		String s3 = new String("Fred");

		if ( s1 == s2 ) {
			System.out.println("s1 and s2 are the same :-)");
		} else {
			System.out.println("s1 and s2 are different???");
		}

		if ( s1 == s3 ) {
			System.out.println("s1 and s3 are the same :-)");
		} else {
			System.out.println("s1 and s3 are different???");
		}
	}

	private static void demoStringIssues2() {
		String s = "abc" ;
		System.out.println(s);
		s.concat("d") ;
		System.out.println(s);
		System.out.println(s.concat("d"));

	}



}
