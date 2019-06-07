package assign2.basic ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.paint.Color;

public class DisplayCarInfo {

	static Map<String, String> locations = new HashMap<>();

	public static void main(String[] args) throws IOException {
		getLocationData();
		FileInputStream fis = new FileInputStream("Car.data");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String carInfo = "";
		int counter = 1;
		while ((carInfo = br.readLine()) != null) {
			System.out.println(counter + " : " + carInfo);
			System.out.println(processCar(carInfo));
			System.out.println();
			counter++;
		}

	}

	static String processCar(String carInfo) {
		String[] info = carInfo.split(",");
		String retInfo = "";
		retInfo = "Model : " ;
		retInfo += processModel(info[1]); // model
		retInfo += "\nEngine : " ;
		retInfo += processEngine(info[2]); // engine
		retInfo += "\nRegistration Details : " ;
		retInfo += processRegPlate(info[0]); // reg plate
		retInfo += "\nColour : " ;
		retInfo += processColour(info[3]); // model
		retInfo += "\nDoors : " ;
		retInfo += processDoors(info[4]); // model
		return retInfo;
	}

	private static String processDoors(String doors) {
		return doors;
	}

	private static String processColour(String colour) {
		String colourName = "n/a";
		colour = colour.replace("(", "" );
		colour = colour.replace(")", "" );
		String[] sRgb = colour.split(":") ;
		int[] iRgb = new int [3] ;
		for (int i = 0; i < sRgb.length; i++) {
			iRgb[i] = Integer.parseInt(sRgb[i]) ;
		}
		Color rgbValue = Color.rgb(iRgb[0], iRgb[1], iRgb[2]) ;
//		System.out.println(rgbValue.toString());
		if ( rgbValue.equals(Color.BLACK)) {
			colourName = "Black" ;
		} else if ( rgbValue.equals(Color.WHITE)) {
			colourName = "White" ;
		} else if ( rgbValue.equals(Color.RED)) {
			colourName = "Red" ;
		} else if ( rgbValue.equals(Color.LIME)) {
			colourName = "Green" ;
		} else if ( rgbValue.equals(Color.BLUE)) {
			colourName = "Blue" ;
		}
		return colourName;
	}

	private static String processEngine(String sEngine) {
		Double dEngine = Double.parseDouble(sEngine) / 1000;
//		System.out.println(dEngine);
		return String.format("%.1fL", dEngine);
	}

	private static String processModel(String model) {
		return model;
	}

	private static String processRegPlate(String regPlate) {
		String retInfo = "";
		retInfo = processYear(regPlate);
		retInfo += " ";
		retInfo += processLocation(regPlate);
		return retInfo;
	}

	static String processLocation(String locationInfo) {
		String retLocInfo = "";
		String firstLetter = locationInfo.substring(0, 1);
		retLocInfo = locations.get(firstLetter);
		return retLocInfo;
	}

	static String processYear(String regPlate) {
		String retYearInfo = "";
		String sYear = regPlate.substring(2, 4);
		int iYear = Integer.parseInt(sYear);
		if (iYear > 50) {
			iYear -= 50;
		}
		iYear += 2000;
		retYearInfo = String.format("%4d", iYear);
		return retYearInfo;

	}

	public static void getLocationData() throws IOException {

		FileInputStream fis = new FileInputStream("Location.data");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null) {
			String[] info = line.split(",");
			locations.put(info[0], info[1]);

		}
//		System.out.println(locations);
	}
}

// public class GenerateCarData {
//
// static HashMap<String, String> locations = new HashMap<>();
// static List<String> makes = new ArrayList
// (Arrays.asList("Volkswagen","BMW","Ford","Honda","Toyota","Vauxhall","Nissan","Mini","Mercedes"))
// ;
// static List<String> colours = new ArrayList
// (Arrays.asList("(255:0:0)","(0:255:0)","(0:0:255)","(0:0:0)","(255:255:255)"))
// ;
// static List<String> doors = new ArrayList (Arrays.asList("3","4","5")) ;
// static List<String> engines = new ArrayList
// (Arrays.asList("1000","1100","1200","1300","1400","1600","2000","2300")) ;
//
//
// public static void main(String[] args) throws IOException {
//
//
// getLocationData();
//// System.out.println(locations);
// FileOutputStream fos = new FileOutputStream("car.data");
// OutputStreamWriter osr = new OutputStreamWriter(fos);
// BufferedWriter bw = new BufferedWriter(osr);
// String regPlate = "" ;
// String make = "" ;
// String colour = "" ;
// String engine = "" ;
// String noOfDoors = "" ;
// StringBuilder newLine ;
// for (int i = 0; i < 500; i++) {
// newLine = new StringBuilder() ;
// regPlate = getRegistration() ;
// make = getRandomValueFromSet(makes) ;
// colour = getRandomValueFromSet(colours);
// noOfDoors = getRandomValueFromSet(doors);
// engine = getRandomValueFromSet(engines) ;
// newLine.append(regPlate);
// newLine.append(",");
// newLine.append(make);
// newLine.append(",");
// newLine.append(engine);
// newLine.append(",");
// newLine.append(colour);
// newLine.append(",");
// newLine.append(noOfDoors);
// System.out.println(newLine);
// bw.write(newLine.toString());
// bw.newLine();
// }
// bw.close();
//
// }
//
//
//
// public static String getRegistration() {
// String year = "";
// String location = "";
// String otherLetters = "";
// year = getRandomYear();
// location = getRandomLocation();
// location += getRandomCharacter();
// otherLetters = getRandomCharacter();
// otherLetters += getRandomCharacter();
// otherLetters += getRandomCharacter();
// return location + year + otherLetters ;
// }
//
// public static String getRandomYear() {
// Random r = new Random();
// int year = 0;
// year = r.nextInt(17) + 1;
// int yearPart2 = r.nextInt(2);
// if (yearPart2 == 1 && year < 17) {
// year += 50;
// }
//
// // System.out.println(String.format("%02d", year));
// return String.format("%02d", year);
// }
//
// public static String getRandomLocation() {
// String sLetter = null;
// do {
//
// Random r = new Random();
// int iLetter = r.nextInt(27);
// iLetter += 65;
// // System.out.println("iLetter = " + iLetter);
// // System.out.println("as a char = " + (char) (iLetter));
// sLetter = String.valueOf((char) iLetter);
// // System.out.println("as a char = " + (char) (iLetter));
// if (!(locations.containsKey(sLetter))) {
// sLetter = null;
// // System.out.println(locations.get(sLetter));
// }
// } while (sLetter == null);
// return sLetter;
//
// }
//
// public static String getRandomCharacter() {
// String sLetter = null;
// do {
//
// Random r = new Random();
// int iLetter = r.nextInt(27);
// iLetter += 65;
// // System.out.println("iLetter = " + iLetter);
// // System.out.println("as a char = " + (char) (iLetter));
// sLetter = String.valueOf((char) iLetter);
// // System.out.println("as a char = " + (char) (iLetter));
// if (!(locations.containsKey(sLetter))) {
// sLetter = null;
// // System.out.println(locations.get(sLetter));
// }
// } while (sLetter == null);
//
// return sLetter;
//
// }
//
// public static void getLocationData() throws IOException {
//
// FileInputStream fis = new FileInputStream("Location.data");
// InputStreamReader isr = new InputStreamReader(fis);
// BufferedReader br = new BufferedReader(isr);
// String line;
// while ((line = br.readLine()) != null) {
// String[] info = line.split(",");
// locations.put(info[0], info[1]);
// // System.out.println(locations);
// }
//
// }
//
// public static String getRandomValueFromSet ( List<String> list ) {
// String val = null ;
// Random r = new Random () ;
// int seed = list.size() ;
// do {
// int i = r.nextInt(seed) ;
// val = list.get(i) ;
// } while ( val == null ) ;
//
// return val ;
// }
//
// }
