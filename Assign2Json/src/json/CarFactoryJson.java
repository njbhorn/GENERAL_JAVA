package json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.scene.paint.Color;


public class CarFactoryJson {

	private List<Car> carsRawData = new ArrayList<>();
	private Location location;
	private Map<String, String> locations;
	FileReader fr;
	BufferedReader br ;
	ObjectMapper om ;

	public CarFactoryJson(String fileName) throws IOException  {
		getLocationData ( "Location.data") ;
		
		carsRawData = getCarDataJson ( fileName ) ;
	}

	public List<Car> getCarsRawData() {
		return carsRawData;
	}
	
	public String getCarsFormattedOutput () {
		
		int counter = 0 ;
		StringBuilder out = new StringBuilder() ;
		Car fmtCar ;
		for ( Car c : carsRawData ) {
			out.append(++counter) ;
			out.append(" : ") ;
			out.append(String.format("%s,%s,%s,%s,%s\n"
									, c.getRegistration()
									, c.getMake()
									, c.getEngine()
									, c.getColour()
									, c.getDoors() )) ;
			fmtCar = processCar ( c ) ;
			out.append(String.format("Model : %s\n", fmtCar.getMake())) ;
			out.append(String.format("Engine : %s\n", fmtCar.getEngine())) ;
			out.append(String.format("Registration Details : %s\n", fmtCar.getRegistration())) ;
			out.append(String.format("Colour : %s\n", fmtCar.getColour())) ;
			out.append(String.format("Doors : %s\n\n", fmtCar.getDoors())) ;
		}
		
		return out.toString() ;
		
	}
	

	private List<Car>  getCarDataJson(String fileName) {
		Car[] cars = null ;
		try {
			fr = new FileReader ( fileName );
			br = new BufferedReader ( fr ) ;
			om = new ObjectMapper() ;
			cars = om.readValue( br,  Car[].class ) ;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Arrays.asList(cars) ;
	}

	private void getLocationData(String fileName) {
		try {
			location = new Location(fileName);
			locations = location.getLocations();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		retLocInfo = locations.get(firstLetter);
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
