package dataentry ;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in).useDelimiter("\r\n");
		String value ;
		String input = "1. Fred, 2. Bill, 3. Mary" ;
		Scanner s2 = new Scanner ( input ).useDelimiter(",") ;
		
		do { 
		
			System.out.println("Enter anything : ");
			
			value = sc.next();
			
			System.out.printf("'%s'\n", value);
			
			System.out.println("Enter number : ");
			
			value = Integer.toString(sc.nextInt()) ;
			
			System.out.printf("'%s'\n", value);
			
			System.out.println("Enter anything : ");
			
			value = sc.nextLine();
			
			System.out.printf("'%s'\n", value);
			
		} while ( !value.equals("")	) ;
		
		System.out.println(s2.next());
		System.out.println(s2.next());
		System.out.println(s2.next());
	}

}
