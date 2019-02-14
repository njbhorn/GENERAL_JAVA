package external;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RunOSCommand {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		String cmd;

		do {
			System.out.println("Type a command to run...");
			cmd = sc.nextLine();
			goRunCmd(cmd);
		} while (cmd != "");
		
		sc.close();
	}

	private static void goRunCmd(String cmd) throws IOException {
		Process p = Runtime.getRuntime().exec(cmd);

		InputStreamReader isr = new InputStreamReader(p.getInputStream());

		BufferedReader br = new BufferedReader(isr);

		System.out.println("Output...");

		String line = br.readLine();

		while (line != null) {
			System.out.println(line);
			line = br.readLine();
		}

	}

}
