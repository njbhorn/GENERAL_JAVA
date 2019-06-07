package assign2.generate ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class GenerateCarData {

	static HashMap<String, String> locations = new HashMap<>();
	static List<String> makes = new ArrayList (Arrays.asList("Volkswagen","BMW","Ford","Honda","Toyota","Vauxhall","Nissan","Mini","Mercedes")) ;
	static List<String> colours = new ArrayList (Arrays.asList("(255:0:0)","(0:255:0)","(0:0:255)","(0:0:0)","(255:255:255)")) ;
	static List<String> doors = new ArrayList (Arrays.asList("3","4","5")) ;
	static List<String> engines = new ArrayList (Arrays.asList("1000","1100","1200","1300","1400","1600","2000","2300")) ;
	

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("car.data");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		System.out.println(br.readLine());
		System.out.println(br.readLine());

		getLocationData();
//		System.out.println(locations);
		FileOutputStream fos = new FileOutputStream("car.data");
		OutputStreamWriter osr = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osr);
		String regPlate = "" ;
		String make = "" ;
		String colour = "" ;
		String engine = "" ;
		String noOfDoors = "" ;
		StringBuilder newLine ;
		for (int i = 0; i < 500; i++) {
			newLine = new StringBuilder() ;
			regPlate = getRegistration() ;
			make = getRandomValueFromSet(makes) ;
			colour = getRandomValueFromSet(colours);
			noOfDoors = getRandomValueFromSet(doors);
			engine = getRandomValueFromSet(engines) ;
			newLine.append(regPlate);
			newLine.append(",");
			newLine.append(make);
			newLine.append(",");
			newLine.append(engine);
			newLine.append(",");
			newLine.append(colour);
			newLine.append(",");
			newLine.append(noOfDoors);
			System.out.println(newLine);
			bw.write(newLine.toString());
			bw.newLine();
		}
		bw.close();
		
	}
	
	
	
	public static String getRegistration() {
		String year = "";
		String location = "";
		String otherLetters = "";
		year = getRandomYear();
		location = getRandomLocation();
		location += getRandomCharacter();
		otherLetters = getRandomCharacter();
		otherLetters += getRandomCharacter();
		otherLetters += getRandomCharacter();
		return location + year + otherLetters ;
	}

	public static String getRandomYear() {
		Random r = new Random();
		int year = 0;
		year = r.nextInt(17) + 1;
		int yearPart2 = r.nextInt(2);
		if (yearPart2 == 1 && year < 17) {
			year += 50;
		}

		// System.out.println(String.format("%02d", year));
		return String.format("%02d", year);
	}

	public static String getRandomLocation() {
		String sLetter = null;
		do {

			Random r = new Random();
			int iLetter = r.nextInt(27);
			iLetter += 65;
			// System.out.println("iLetter = " + iLetter);
			// System.out.println("as a char = " + (char) (iLetter));
			sLetter = String.valueOf((char) iLetter);
			// System.out.println("as a char = " + (char) (iLetter));
			if (!(locations.containsKey(sLetter))) {
				sLetter = null;
				// System.out.println(locations.get(sLetter));
			}
		} while (sLetter == null);
		return sLetter;

	}

	public static String getRandomCharacter() {
		String sLetter = null;
		do {

			Random r = new Random();
			int iLetter = r.nextInt(27);
			iLetter += 65;
			// System.out.println("iLetter = " + iLetter);
			// System.out.println("as a char = " + (char) (iLetter));
			sLetter = String.valueOf((char) iLetter);
			// System.out.println("as a char = " + (char) (iLetter));
			if (!(locations.containsKey(sLetter))) {
				sLetter = null;
				// System.out.println(locations.get(sLetter));
			}
		} while (sLetter == null);

		return sLetter;

	}

	public static void getLocationData() throws IOException {

		FileInputStream fis = new FileInputStream("Location.data");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null) {
			String[] info = line.split(",");
			locations.put(info[0], info[1]);
			// System.out.println(locations);
		}

	}
	
	public static String getRandomValueFromSet ( List<String> list ) {
		String val = null ;
		Random r = new Random () ;
		int seed = list.size()  ;
		do {
			int i = r.nextInt(seed) ;
			val = list.get(i) ;
		} while ( val == null ) ;
		
		return val ;
	}

}
