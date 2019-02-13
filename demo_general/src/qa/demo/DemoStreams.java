package qa.demo;

import java.util.Arrays;
import java.util.List;

public class DemoStreams {

	public static void main(String[] args) {

//		String s = "fred" ;

		List<String> list = Arrays.asList("a3", "a2", "a1", "b1","c2","c1") ;

		list.stream()
			.filter(s -> s.startsWith ("a" ))
			.map(String::toUpperCase)
			.sorted()
			.forEach(System.out::println);
//			.forEach(s -> System.out.println(s));
			;



	}

}
