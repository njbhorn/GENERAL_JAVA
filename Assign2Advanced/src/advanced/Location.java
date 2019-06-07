package advanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Location {
	
	private String areaCode ;
	private String areaName ;
	private Map<String,char[]> district ;
	
	public Location(String areaCode, String areaName, String district, String characters ) {
		this.areaCode = areaCode;
		this.areaName = areaName;
		this.district = new HashMap<String, char[]>() ;
		this.processDistrict(district, characters);
	}
	
	private void processDistrict( String district, String characters ) {
		char[] asCharacters = characters.toCharArray() ;
		this.district.put(district, asCharacters) ;
	}
	
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	@Override
	public String toString() {
		return "Location [" + areaCode + ", " + areaName + ", districts=" + district.keySet() + "]";
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Map<String, char[]> getDistrict() {
		return district;
	}

	public void setDistrict(Map<String, char[]> district) {
		this.district = district;
	}

	public String getSpecificDistrict(String secondLetter) {
		String districtName = "" ;
		Map<String,char[]> district = this.getDistrict() ;
		for ( Entry<String,char[]> info : district.entrySet() ) {
//			System.out.println(Arrays.toString(info.getValue()) + "\"" + info.getKey());
			for ( char code : info.getValue() ) {
				if ( Character.toString(code).equals(secondLetter)) {
					districtName = info.getKey() ;
					break ;
				}
			}
		}
		return districtName ;
	}
	
	
	
	

}
