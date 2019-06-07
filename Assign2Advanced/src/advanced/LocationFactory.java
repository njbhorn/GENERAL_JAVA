package advanced;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LocationFactory {

	private List<Location> locations = new ArrayList<>();
	private String fileName;
	private final String VALIDCODES = "ABCDEFGHJKLMNOPQRSTUVWXYZ" ;

	public LocationFactory(String fileName) throws IOException {
		this.fileName = fileName;
		this.getDataFromFile();
	}

	public String getFileName() {
		return fileName;
	}

	public List<Location> getLocations() {
		return locations;
	}
	
	public Location getSpecificLocation ( String location ) {
		Location foundLoc = null ;
		for ( Location loc : locations ) {
			if ( loc.getAreaCode().equals(location ) ) {
				foundLoc = loc ;
			}
		}
		return foundLoc;
		
	}

	private void getDataFromFile() throws IOException {
		// FileInputStream fis = new FileInputStream(this.fileName);
		// InputStreamReader isr = new InputStreamReader(fis);
		// BufferedReader br = new BufferedReader(isr);
		Path p = Paths.get(this.fileName);
		List<String> allLines = Files.readAllLines(p, Charset.forName("iso-8859-1") );
		String areaCode = "" ;
		String areaCodePrev = "" ;
		String areaName = "" ;
		String areaNamePrev = "" ;
		String district = "" ;
		String codes = "" ;
		char[] codesAsArray = null ; 
		Location location = null ;
		int index = 0 ;
		for (String line : allLines) {
			String[] info = line.split("\t");
			if ( info.length != 4 ) {
				System.out.println(info);
			}
			areaCode = info[0] ;
			areaName = info[1] ;
			district = info[2] ;
			codes = cleanUpCodes ( info[3] ) ;
			codesAsArray = codes.toCharArray() ;
			if ( areaCode.equals(areaCodePrev)) {
				// don't create a new location just add...
				Map < String, char[]> districts = location.getDistrict() ;
				districts.put(district, codesAsArray);
				location.setDistrict(districts);
				index = locations.indexOf(location) ;
				locations.set(index, location);
			} else {
				// new area code
				location = new Location ( areaCode, areaName, district, codes) ;
				locations.add(location) ;
				areaCodePrev = areaCode ;
			}
			
		}

		 System.out.println(locations);

	}

	private String cleanUpCodes(String codes) {
//		System.out.println("Before " + codes);
		
		// remove spaces and any A-Y etc.
		String fmtCodes = "" ;
		fmtCodes = codes.replace(" ", "") ;
		if ( codes.length() > 1 && codes.substring(1, 2).equals("-") ) {
			fmtCodes = VALIDCODES ;
		}
//		System.out.println("After " + fmtCodes);
		return fmtCodes;
	}

	public void refreshLocationCache() throws IOException {
		this.getDataFromFile();
	}

}
