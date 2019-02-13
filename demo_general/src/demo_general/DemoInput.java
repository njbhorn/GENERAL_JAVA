package demo_general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DemoInput {

	public static void main(String[] args) {
		
		System.out.println("Enter something... ");
		
		try (BufferedReader br = new BufferedReader(new
				InputStreamReader (System.in))) {
				br.readLine();
			} catch (IOException e) {}

		System.out.println("Finished...");

	}

}
