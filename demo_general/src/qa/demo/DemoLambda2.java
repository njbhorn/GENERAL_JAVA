package qa.demo;

import java.util.ArrayList;
import java.util.List;

public class DemoLambda2 {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("s1");
		list.add("s2");
		list.add("s3");

		for ( String s : list ) {
			System.out.println(s);
		}

		list.forEach( s -> {
			System.out.println(s) ;
		});
		
		callDemo ( list, "code") ;
		
		callMethod ( list , s-> System.out.println(s));

	}

	private static void callDemo(List<String> list, String string) {
		// TODO Auto-generated method stub
		
	}

	private static void callMethod(List<String> list, Object object) {
		// TODO Auto-generated method stub
		
	}

}
