package qa.demo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DemoGenerics {

	public static void main(String[] args) {
		List<String> al = new ArrayList<>() ;
		al.add("Nigel");
		al.add("Harry");
//		al.add(999);
//		al.add(new Date());

		for ( Object o : al ) {
			String s = ( String ) o ;
			System.out.println(s.toUpperCase());
		}

		demo ( "s1", "s2") ;
		demo ( "s1", "s2","s3", "s4") ;

	}

	public static void demo( String... s ) {
		System.out.println(s.length);
	}

}
