package json;

import java.util.List;

public class Program {

	public static void main(String[] args) {

		
		
		try {
			
			CarFactoryJson cfj = new CarFactoryJson("Car.json") ;
			
			List<Car> carBasicList = cfj.getCarsRawData() ;
			
			System.out.println(carBasicList);
			
			System.out.println();
			
			System.out.println(cfj.getCarsFormattedOutput());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
