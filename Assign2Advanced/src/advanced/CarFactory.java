package advanced;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javafx.scene.paint.Color;

public class CarFactory {

	private List<String> carInfo;
	private List<Car> carsRawData = new ArrayList<>();
	private List<Car> carsFormattedData = new ArrayList<>();
	private LocationFactory locationFactory;
	private List<Location> locations;

	public CarFactory() throws IOException {
		locationFactory = new LocationFactory("LocationAdvanced.data");
		locations = locationFactory.getLocations();
	}

	public void initialise(String filename) throws IOException {
		getCarInfoFromFile(filename);
		getRawCarInfoFromList();
		getFormattedCarInfoFromRaw();
	}

	public void showBasicData() {
		StringBuilder out = new StringBuilder();
		String carOriginal = null ;
		Car carFormatted = null ;
		for (int i = 0; i < carInfo.size(); i++) {
			carOriginal = carInfo.get(i) ;
			out.append(carOriginal);
			carFormatted = carsFormattedData.get(i);
			out.append("\nModel : ");
			out.append(carFormatted.getMake()); // model
			out.append("\nEngine : ");
			out.append(carFormatted.getEngine()); // engine
			out.append("\nRegistration Details : ");
			out.append(carFormatted.getRegistration()); // reg plate
			out.append("\nColour : ");
			out.append(carFormatted.getColour()); // colour
			out.append("\nDoors : ");
			out.append(carFormatted.getDoors());// doors
			out.append("\n\n");
		}

		System.out.println(out.toString());

	}

	private void getCarInfoFromFile(String carInfoFile) throws IOException {
		// FileInputStream fis = new FileInputStream(carInfoFile);
		// InputStreamReader isr = new InputStreamReader(fis);
		// BufferedReader br = new BufferedReader(isr);
		Path p = Paths.get(carInfoFile);
		carInfo = Files.readAllLines(p);
	}

	private String getRawCarInfoFromList() {
		Car c = null;
		for (String sCar : carInfo) {
			c = makeCarFromString(sCar);
			populateCarRawDataArrayWithCar(c);
		}
		return null;

	}

	private String getFormattedCarInfoFromRaw() {
		Car carFmt;
		for (Car c : carsRawData) {
			carFmt = processCar(c);
			populateCarFormattedDataArrayWithCar(carFmt);
		}
		return null;

	}

	private Car makeCarFromString(String sCar) {
		String[] info = sCar.split(",");
		Car c = new Car(info);
		// retInfo += processModel(); // model
		// retInfo += processEngine(); // engine
		// retInfo += processRegPlate(); // reg plate
		// retInfo += processColour(info[3]); // model
		// retInfo += processDoors(info[4]); // model
		return c;
	}

	private int populateCarRawDataArrayWithCar(Car c) {
		carsRawData.add(c);
		return carsRawData.size();
	}

	private int populateCarFormattedDataArrayWithCar(Car c) {
		carsFormattedData.add(c);
		return carsFormattedData.size();
	}

	private Car processCar(Car car) {

		String regPlate = processRegPlate(car.getRegistration()); // reg plate
		String model = processModel(car.getMake()); // model
		String engine = processEngine(car.getEngine()); // engine
		String colour = processColour(car.getColour()); // model
		String doors = processDoors(car.getDoors()); // model

		return new Car(regPlate, model, engine, colour, doors);

	}

	private String processDoors(String doors) {
		return doors;
	}

	private String processColour(String colour) {
		Color rgbValue = getRGBFromString ( colour ) ;
		String colourName = "n/a";
		// System.out.println(rgbValue.toString());
		if (rgbValue.equals(Color.BLACK)) {
			colourName = "Black";
		} else if (rgbValue.equals(Color.WHITE)) {
			colourName = "White";
		} else if (rgbValue.equals(Color.RED)) {
			colourName = "Red";
		} else if (rgbValue.equals(Color.LIME)) {
			colourName = "Green";
		} else if (rgbValue.equals(Color.BLUE)) {
			colourName = "Blue";
		}
		return colourName;
	}
	
	private Color getRGBFromString ( String colour ) {
		
		colour = colour.replace("(", "");
		colour = colour.replace(")", "");
		String[] sRgb = colour.split(":");
		int[] iRgb = new int[3];
		for (int i = 0; i < sRgb.length; i++) {
			iRgb[i] = Integer.parseInt(sRgb[i]);
		}
		Color rgbValue = Color.rgb(iRgb[0], iRgb[1], iRgb[2]);
		return rgbValue ;
	}

	private String processEngine(String sEngine) {
		Double dEngine = Double.parseDouble(sEngine) / 1000;
		// System.out.println(dEngine);
		return String.format("%.1fL", dEngine);
	}

	private String processModel(String model) {
		return model;
	}

	private String processRegPlate(String regPlate) {
		String retInfo = "";
		retInfo = processYear(regPlate);
		retInfo += " ";
		retInfo += processLocation(regPlate);
		return retInfo;
	}

	private String processLocation(String locationInfo) {
		String retLocInfo = "";
		String firstLetter = locationInfo.substring(0, 1);
		String secondLetter = locationInfo.substring(1, 2);
		Location location = locationFactory.getSpecificLocation(firstLetter);
		retLocInfo += location.getAreaName() ;
		retLocInfo += " (" ;
		retLocInfo += location.getSpecificDistrict(secondLetter) ;
		retLocInfo += ")" ;
//		Map<String,char[]> district = location.getDistrict() ;
//		for ( Entry<String,char[]> info : district.entrySet() ) {
//			System.out.println(Arrays.toString(info.getValue()) + "\"" + info.getKey());
//		}
		return retLocInfo;
	}

	private String processYear(String regPlate) {
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
}
